package org.acme;

import org.hibernate.annotations.Nationalized;

import jakarta.persistence.*;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * @author shoeltker
 */
@Entity
@Indexed
@Table(name = "NEWS")
@NamedQueries({
  @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n"),
  @NamedQuery(name = "News.findUndeletedById", query = "SELECT n FROM News n WHERE n.deleted = false AND n.id = :id"),
  @NamedQuery(name = "News.findUndeleted", query = "SELECT n FROM News n WHERE n.deleted = false")
})
public class News implements Serializable
{

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_News")
  @SequenceGenerator(name = "SEQ_News", sequenceName = "SEQ_News", allocationSize = 1)
  @Column(name = "ID", nullable = false)
  private Long id;
  @Basic(optional = false)
  
  @Nationalized
  @Column(name = "TITEL", nullable = false, length = 1024)
  @FullTextField(analyzer = "german")
  private String titel;
  @Basic(optional = false)
  
  @Nationalized
  @Column(name = "CONTENT", nullable = false, columnDefinition = "NCLOB")
  private String content;
  @Column(name = "VEROEFFENTLICHTDATE", nullable = true)
  private LocalDateTime veroeffentlichtdate;
  @Column(name = "GUELTIGVON", nullable = true)
  private LocalDateTime gueltigVon;
  @Column(name = "GUELTIGBIS", nullable = true)
  private LocalDateTime gueltigBis;
  @Column(name = "KONTAKTNAME", length = 512)
  private String kontaktname;
  @Column(name = "KONTAKTFIRMA", length = 512)
  private String kontaktfirma;
  @Column(name = "KONTAKTTEL", length = 512)
  private String kontakttel;
  @Column(name = "KONTAKTEMAIL", length = 512)
  private String kontaktemail;
  @Column(name = "KONTAKTPOS", length = 512)
  private String kontaktpos;
  @Column(name = "KONTAKTABTEILUNG", length = 512)
  private String kontaktabteilung;
  @Column(name = "KONTAKTUID", length = 255)
  private String kontaktuid;
  @Basic(optional = false)
  
  @Column(name = "LASTCHANGEDATE", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastchangedate;
  @Basic(optional = false)
  
  @Column(name = "LASTCHANGEUSER", nullable = false, length = 255)
  private String lastchangeuser;
  @Column(name = "VORSCHAUDOKID", nullable = true)
  private Long vorschauDokId;
  @Basic(optional = false)
  
  @Column(name = "DELETED", nullable = false, columnDefinition = "NUMBER(1,0) default 0")
  private boolean deleted = false;
  @Column(name = "FIRSTPUBLISHED", nullable = true)
  private LocalDateTime firstPublished;
  @Basic(optional = false)
  
  @Column(name = "AUTOPUBNOTIFY", nullable = false, columnDefinition = "NUMBER(1,0) default 0")
  private boolean autoPubNotify = false;
  @Basic(optional = false)
  
  @Column(name = "ORIGINALCREATORUID", nullable = false, length = 255, columnDefinition = "NVARCHAR2(255) NOT NULL")
  private String originalCreatorUid;

  public News()
  {
  }

  public News(Long id)
  {
    this.id = id;
  }

  public News(Long id, String titel, String content, LocalDateTime veroeffentlichtdate, Date lastchangedate,
              String lastchangeuser, Long vorschauDokId)
  {
    this.id = id;
    this.titel = titel;
    this.content = content;
    this.veroeffentlichtdate = veroeffentlichtdate;
    this.lastchangedate = lastchangedate;
    this.lastchangeuser = lastchangeuser;
    this.vorschauDokId = vorschauDokId;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getTitel()
  {
    return titel;
  }

  public void setTitel(String titel)
  {
    this.titel = titel;
  }

  public String getContent()
  {
    return content;
  }

  public void setContent(String content)
  {
    this.content = content;
  }

  public LocalDateTime getVeroeffentlichtdate()
  {
    return veroeffentlichtdate;
  }

  public void setVeroeffentlichtdate(LocalDateTime veroeffentlichtdate)
  {
    this.veroeffentlichtdate = veroeffentlichtdate;
  }

  public String getKontaktname()
  {
    return kontaktname;
  }

  public void setKontaktname(String kontaktname)
  {
    this.kontaktname = kontaktname;
  }

  public String getKontaktfirma()
  {
    return kontaktfirma;
  }

  public void setKontaktfirma(String kontaktfirma)
  {
    this.kontaktfirma = kontaktfirma;
  }

  public String getKontakttel()
  {
    return kontakttel;
  }

  public void setKontakttel(String kontakttel)
  {
    this.kontakttel = kontakttel;
  }

  public String getKontaktemail()
  {
    return kontaktemail;
  }

  public void setKontaktemail(String kontaktemail)
  {
    this.kontaktemail = kontaktemail;
  }

  public String getKontaktpos()
  {
    return kontaktpos;
  }

  public void setKontaktpos(String kontaktpos)
  {
    this.kontaktpos = kontaktpos;
  }

  public String getKontaktuid()
  {
    return kontaktuid;
  }

  public void setKontaktuid(String kontaktuid)
  {
    this.kontaktuid = kontaktuid;
  }

  public Date getLastchangedate()
  {
    return lastchangedate;
  }

  public void setLastchangedate(Date lastchangedate)
  {
    this.lastchangedate = lastchangedate;
  }

  public String getLastchangeuser()
  {
    return lastchangeuser;
  }

  public void setLastchangeuser(String lastchangeuser)
  {
    this.lastchangeuser = lastchangeuser;
  }

  public Long getVorschauDokId()
  {
    return this.vorschauDokId;
  }

  public void setVorschauDokId(Long vorschauDokId)
  {
    this.vorschauDokId = vorschauDokId;
  }

  public LocalDateTime getGueltigVon()
  {
    return gueltigVon;
  }

  public void setGueltigVon(LocalDateTime gueltigVon)
  {
    this.gueltigVon = gueltigVon;
  }

  public LocalDateTime getGueltigBis()
  {
    return gueltigBis;
  }

  public void setGueltigBis(LocalDateTime gueltigBis)
  {
    this.gueltigBis = gueltigBis;
  }

  public String getKontaktabteilung()
  {
    return kontaktabteilung;
  }

  public void setKontaktabteilung(String kontaktabteilung)
  {
    this.kontaktabteilung = kontaktabteilung;
  }

  public boolean isDeleted()
  {
    return deleted;
  }

  public void setDeleted(boolean deleted)
  {
    this.deleted = deleted;
  }

  public LocalDateTime getFirstPublished()
  {
    return firstPublished;
  }

  public void setFirstPublished(LocalDateTime firstPublished)
  {
    this.firstPublished = firstPublished;
  }

  public boolean isAutoPubNotify()
  {
    return autoPubNotify;
  }

  public void setAutoPubNotify(boolean autoPubNotify)
  {
    this.autoPubNotify = autoPubNotify;
  }

  public String getOriginalCreatorUid()
  {
    return originalCreatorUid;
  }

  public void setOriginalCreatorUid(String originalCreatorUid)
  {
    this.originalCreatorUid = originalCreatorUid;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    News news = (News) o;
    return deleted == news.deleted && autoPubNotify == news.autoPubNotify && Objects.equals(id, news.id) && Objects.equals(titel, news.titel) && Objects.equals(content, news.content) && Objects.equals(veroeffentlichtdate, news.veroeffentlichtdate) && Objects.equals(gueltigVon, news.gueltigVon) && Objects.equals(gueltigBis, news.gueltigBis) && Objects.equals(kontaktname, news.kontaktname) && Objects.equals(kontaktfirma, news.kontaktfirma) && Objects.equals(kontakttel, news.kontakttel) && Objects.equals(kontaktemail, news.kontaktemail) && Objects.equals(kontaktpos, news.kontaktpos) && Objects.equals(kontaktabteilung, news.kontaktabteilung) && Objects.equals(kontaktuid, news.kontaktuid) && Objects.equals(lastchangedate, news.lastchangedate) && Objects.equals(lastchangeuser, news.lastchangeuser) && Objects.equals(vorschauDokId, news.vorschauDokId) && Objects.equals(firstPublished, news.firstPublished) && Objects.equals(originalCreatorUid, news.originalCreatorUid);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(id, titel, content, veroeffentlichtdate, gueltigVon, gueltigBis, kontaktname, kontaktfirma, kontakttel, kontaktemail, kontaktpos, kontaktabteilung, kontaktuid, lastchangedate, lastchangeuser, vorschauDokId, deleted, firstPublished, autoPubNotify, originalCreatorUid);
  }

  @Override
  public String toString()
  {
    return "News{" +
      "id=" + id +
      ", titel='" + titel + '\'' +
      ", content='" + content + '\'' +
      ", veroeffentlichtdate=" + veroeffentlichtdate +
      ", gueltigVon=" + gueltigVon +
      ", gueltigBis=" + gueltigBis +
      ", kontaktname='" + kontaktname + '\'' +
      ", kontaktfirma='" + kontaktfirma + '\'' +
      ", kontakttel='" + kontakttel + '\'' +
      ", kontaktemail='" + kontaktemail + '\'' +
      ", kontaktpos='" + kontaktpos + '\'' +
      ", kontaktabteilung='" + kontaktabteilung + '\'' +
      ", kontaktuid='" + kontaktuid + '\'' +
      ", lastchangedate=" + lastchangedate +
      ", lastchangeuser='" + lastchangeuser + '\'' +
      ", vorschauDokId=" + vorschauDokId +
      ", deleted=" + deleted +
      ", firstPublished=" + firstPublished +
      ", autoPubNotify=" + autoPubNotify +
      ", originalCreatorUid='" + originalCreatorUid + '\'' +
      '}';
  }
}
