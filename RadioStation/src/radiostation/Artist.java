package radiostation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "ARTIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artist.findAll", query = "SELECT a FROM Artist a"),
    @NamedQuery(name = "Artist.findByArtistid", query = "SELECT a FROM Artist a WHERE a.artistID = :artistID"),
    @NamedQuery(name = "Artist.findByFirstname", query = "SELECT a FROM Artist a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "Artist.findByLastname", query = "SELECT a FROM Artist a WHERE a.lastName = :lastName"),
    @NamedQuery(name = "Artist.findByArtisticname", query = "SELECT a FROM Artist a WHERE a.artisticName = :artisticName"),
    @NamedQuery(name = "Artist.findBySex", query = "SELECT a FROM Artist a WHERE a.sex = :sex"),
    @NamedQuery(name = "Artist.findByBirthday", query = "SELECT a FROM Artist a WHERE a.birthDay = :birthDay"),
    @NamedQuery(name = "Artist.findByBirthplace", query = "SELECT a FROM Artist a WHERE a.birthPlace = :birthPlace")})
public class Artist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ARTISTID")
    private Long artistID;
    @Basic(optional = false)
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LASTNAME")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "ARTISTICNAME")
    private String artisticName;
    @Basic(optional = false)
    @Column(name = "SEX")
    private String sex;
    @Basic(optional = false)
    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDay;
    @Basic(optional = false)
    @Column(name = "BIRTHPLACE")
    private String birthPlace;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artistID")
    private List<ArtistMusicGroup> artistMusicGroupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artistID")
    private List<Album> albumList;

    public Artist() {
    }

    public Artist(Long artistID) {
        this.artistID = artistID;
    }

    public Artist(Long artistID, String firstName, String lastName, String artisticName, String sex, Date birthDay, String birthPlace) {
        this.artistID = artistID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.artisticName = artisticName;
        this.sex = sex;
        this.birthDay = birthDay;
        this.birthPlace = birthPlace;
    }

    public Long getArtistid() {
        return artistID;
    }

    public void setArtistid(Long artistID) {
        this.artistID = artistID;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    public String getArtisticname() {
        return artisticName;
    }

    public void setArtisticname(String artisticName) {
        this.artisticName = artisticName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthDay;
    }

    public void setBirthday(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthplace() {
        return birthPlace;
    }

    public void setBirthplace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @XmlTransient
    public List<ArtistMusicGroup> getArtistMusicGroupList() {
        return artistMusicGroupList;
    }

    public void setArtistMusicGroupList(List<ArtistMusicGroup> artistMusicGroupList) {
        this.artistMusicGroupList = artistMusicGroupList;
    }

    @XmlTransient
    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artistID != null ? artistID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artist)) {
            return false;
        }
        Artist other = (Artist) object;
        if ((this.artistID == null && other.artistID != null) || (this.artistID != null && !this.artistID.equals(other.artistID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "radiostation.Artist[ artistID=" + artistID + " ]";
    }

}
