package org.acme;


import org.hibernate.search.backend.elasticsearch.analysis.ElasticsearchAnalysisConfigurationContext;
import org.hibernate.search.backend.elasticsearch.analysis.ElasticsearchAnalysisConfigurer;

import io.quarkus.hibernate.search.orm.elasticsearch.SearchExtension;

@SearchExtension
public class AnalysisConfigurer
        implements ElasticsearchAnalysisConfigurer
{

  @Override
  public void configure(ElasticsearchAnalysisConfigurationContext context)
  {

    context.analyzer("english").custom()
            .tokenizer("standard")
            .tokenFilters("asciifolding", "lowercase", "porter_stem");
  }
}
