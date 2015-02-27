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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "SONG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Song.findAll", query = "SELECT s FROM Song s"),
    @NamedQuery(name = "Song.findBySongid", query = "SELECT s FROM Song s WHERE s.songid = :songid"),
    @NamedQuery(name = "Song.findByTitle", query = "SELECT s FROM Song s WHERE s.title = :title"),
    @NamedQuery(name = "Song.findByDuration", query = "SELECT s FROM Song s WHERE s.duration = :duration"),
    @NamedQuery(name = "Song.findByTracknr", query = "SELECT s FROM Song s WHERE s.tracknr = :tracknr")})
public class Song implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SONGID")
    private Long songid;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DURATION")
    private BigInteger duration;
    @Column(name = "TRACKNR")
    private BigInteger tracknr;
    @OneToMany(mappedBy = "songid")
    private List<AlbumSong> albumSongList;
    @OneToMany(mappedBy = "songid")
    private List<PlayListSong> playListSongList;
    @OneToMany(mappedBy = "songid")
    private List<Album> albumList;

    public Song() {
    }

    public Song(Long songid) {
        this.songid = songid;
    }

    public Long getSongid() {
        return songid;
    }

    public void setSongid(Long songid) {
        this.songid = songid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigInteger getDuration() {
        return duration;
    }

    public void setDuration(BigInteger duration) {
        this.duration = duration;
    }

    public BigInteger getTracknr() {
        return tracknr;
    }

    public void setTracknr(BigInteger tracknr) {
        this.tracknr = tracknr;
    }

    @XmlTransient
    public List<AlbumSong> getAlbumSongList() {
        return albumSongList;
    }

    public void setAlbumSongList(List<AlbumSong> albumSongList) {
        this.albumSongList = albumSongList;
    }

    @XmlTransient
    public List<PlayListSong> getPlayListSongList() {
        return playListSongList;
    }

    public void setPlayListSongList(List<PlayListSong> playListSongList) {
        this.playListSongList = playListSongList;
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
        hash += (songid != null ? songid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Song)) {
            return false;
        }
        Song other = (Song) object;
        if ((this.songid == null && other.songid != null) || (this.songid != null && !this.songid.equals(other.songid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Song[ songid=" + songid + " ]";
    }

}
