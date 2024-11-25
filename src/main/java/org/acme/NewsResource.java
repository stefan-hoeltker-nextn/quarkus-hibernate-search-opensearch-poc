package org.acme;

import java.util.Optional;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.hibernate.search.mapper.orm.mapping.SearchMapping;
import org.jboss.resteasy.reactive.RestQuery;
import org.hibernate.search.mapper.orm.session.SearchSession;

import java.util.List;

@Path("/news")
public class NewsResource
{
  @Inject
  SearchSession searchSession;

  @Inject
  SearchMapping searchMapping;

  void onStart(@Observes StartupEvent ev) throws InterruptedException {
    // only reindex if we imported some content
//    if (Book.count() > 0) {
      searchMapping.scope(Object.class)
              .massIndexer()
              .startAndWait();
//    }
  }

  @GET
  @Path("title/search")
  @Transactional
  public List<News> searchAuthors(@RestQuery String pattern,
                                  @RestQuery Optional<Integer> size)
  {
//    return null;
    return searchSession.search(News.class)
            .where(f ->
                    pattern == null || pattern.trim().isEmpty() ?
                            f.matchAll() :
                            f.simpleQueryString()
                                    .fields("books.title").matching(pattern)
            )
            .fetchHits(size.orElse(20));
  }

}
