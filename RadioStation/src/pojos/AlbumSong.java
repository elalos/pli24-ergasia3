package pojos;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ALBUMSONG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlbumSong.findAll", query = "SELECT a FROM AlbumSong a"),
    @NamedQuery(name = "AlbumSong.findByAlbumsongid", query = "SELECT a FROM AlbumSong a WHERE a.albumsongid = :albumsongid")})
public class AlbumSong implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ALBUMSONGID")
    private Long albumsongid;
    @JoinColumn(name = "ALBUMID", referencedColumnName = "ALBUMID")
    @ManyToOne
    private Album albumid;
    @JoinColumn(name = "SONGID", referencedColumnName = "SONGID")
    @ManyToOne
    private Song songid;

    public AlbumSong() {
    }

    public AlbumSong(Long albumsongid) {
        this.albumsongid = albumsongid;
    }

    public Long getAlbumsongid() {
        return albumsongid;
    }

    public void setAlbumsongid(Long albumsongid) {
        this.albumsongid = albumsongid;
    }

    public Album getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Album albumid) {
        this.albumid = albumid;
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
        hash += (albumsongid != null ? albumsongid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlbumSong)) {
            return false;
        }
        AlbumSong other = (AlbumSong) object;
        if ((this.albumsongid == null && other.albumsongid != null) || (this.albumsongid != null && !this.albumsongid.equals(other.albumsongid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.AlbumSong[ albumsongid=" + albumsongid + " ]";
    }

}
