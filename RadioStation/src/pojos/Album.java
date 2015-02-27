package pojos;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "ALBUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.findByAlbumid", query = "SELECT a FROM Album a WHERE a.albumid = :albumid"),
    @NamedQuery(name = "Album.findByTitle", query = "SELECT a FROM Album a WHERE a.title = :title"),
    @NamedQuery(name = "Album.findByReleasedate", query = "SELECT a FROM Album a WHERE a.releasedate = :releasedate"),
    @NamedQuery(name = "Album.findByType", query = "SELECT a FROM Album a WHERE a.type = :type"),
    @NamedQuery(name = "Album.findByDisknumber", query = "SELECT a FROM Album a WHERE a.disknumber = :disknumber")})
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ALBUMID")
    private Long albumid;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "RELEASEDATE")
    private String releasedate;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "DISKNUMBER")
    private BigInteger disknumber;
    @OneToMany(mappedBy = "albumid")
    private List<AlbumSong> albumSongList;
    @JoinColumn(name = "ARTISTID", referencedColumnName = "ARTISTID")
    @ManyToOne
    private Artist artistid;
    @JoinColumn(name = "MUSICGROUPID", referencedColumnName = "MUSICGROUPID")
    @ManyToOne
    private MusicGroup musicgroupid;
    @JoinColumn(name = "MUSICPRODUCTIONCOMPANYID", referencedColumnName = "MUSICPRODUCTIONCOMPANYID")
    @ManyToOne
    private MusicProductionCompany musicproductioncompanyid;
    @JoinColumn(name = "SONGID", referencedColumnName = "SONGID")
    @ManyToOne
    private Song songid;

    public Album() {
    }

    public Album(Long albumid) {
        this.albumid = albumid;
    }

    public Long getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Long albumid) {
        this.albumid = albumid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigInteger getDisknumber() {
        return disknumber;
    }

    public void setDisknumber(BigInteger disknumber) {
        this.disknumber = disknumber;
    }

    @XmlTransient
    public List<AlbumSong> getAlbumSongList() {
        return albumSongList;
    }

    public void setAlbumSongList(List<AlbumSong> albumSongList) {
        this.albumSongList = albumSongList;
    }

    public Artist getArtistid() {
        return artistid;
    }

    public void setArtistid(Artist artistid) {
        this.artistid = artistid;
    }

    public MusicGroup getMusicgroupid() {
        return musicgroupid;
    }

    public void setMusicgroupid(MusicGroup musicgroupid) {
        this.musicgroupid = musicgroupid;
    }

    public MusicProductionCompany getMusicproductioncompanyid() {
        return musicproductioncompanyid;
    }

    public void setMusicproductioncompanyid(MusicProductionCompany musicproductioncompanyid) {
        this.musicproductioncompanyid = musicproductioncompanyid;
    }

    public Song getSongid() {
        return songid;
    }

    public void setSongid(Song songid) {
        this.songid = songid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (albumid != null ? albumid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.albumid == null && other.albumid != null) || (this.albumid != null && !this.albumid.equals(other.albumid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Album[ albumid=" + albumid + " ]";
    }

}
