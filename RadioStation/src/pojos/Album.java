package pojos;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "ALBUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.findByAlbumid", query = "SELECT a FROM Album a WHERE a.albumID = :albumID"),
    @NamedQuery(name = "Album.findByTitle", query = "SELECT a FROM Album a WHERE a.title = :title"),
    @NamedQuery(name = "Album.findByReleasedate", query = "SELECT a FROM Album a WHERE a.releaseDate = :releaseDate"),
    @NamedQuery(name = "Album.findByType", query = "SELECT a FROM Album a WHERE a.type = :type"),
    @NamedQuery(name = "Album.findByDisknumber", query = "SELECT a FROM Album a WHERE a.diskNumber = :diskNumber")})
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ALBUMID")
    private Long albumID;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "RELEASEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseDate;
    @Basic(optional = false)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @Column(name = "DISKNUMBER")
    private long diskNumber;
    @JoinColumn(name = "ARTISTID", referencedColumnName = "ARTISTID")
    @ManyToOne(optional = false)
    private Artist artistID;
    @JoinColumn(name = "MUSICGROUPID", referencedColumnName = "MUSICGROUPID")
    @ManyToOne(optional = false)
    private MusicGroup musicGroupID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "albumID")
    private List<SongAlbum> songAlbumList;

    public Album() {
    }

    public Album(Long albumID) {
        this.albumID = albumID;
    }

    public Album(Long albumID, String title, Date releaseDate, String type, long diskNumber) {
        this.albumID = albumID;
        this.title = title;
        this.releaseDate = releaseDate;
        this.type = type;
        this.diskNumber = diskNumber;
    }

    public Long getAlbumid() {
        return albumID;
    }

    public void setAlbumid(Long albumID) {
        this.albumID = albumID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleasedate() {
        return releaseDate;
    }

    public void setReleasedate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getDisknumber() {
        return diskNumber;
    }

    public void setDisknumber(long diskNumber) {
        this.diskNumber = diskNumber;
    }

    public Artist getArtistid() {
        return artistID;
    }

    public void setArtistid(Artist artistID) {
        this.artistID = artistID;
    }

    public MusicGroup getMusicgroupid() {
        return musicGroupID;
    }

    public void setMusicgroupid(MusicGroup musicGroupID) {
        this.musicGroupID = musicGroupID;
    }

    @XmlTransient
    public List<SongAlbum> getSongAlbumList() {
        return songAlbumList;
    }

    public void setSongAlbumList(List<SongAlbum> songAlbumList) {
        this.songAlbumList = songAlbumList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (albumID != null ? albumID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.albumID == null && other.albumID != null) || (this.albumID != null && !this.albumID.equals(other.albumID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "radiostation.Album[ albumID=" + albumID + " ]";
    }

}
