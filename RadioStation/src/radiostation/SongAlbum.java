package radiostation;

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
@Table(name = "SONGALBUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SongAlbum.findAll", query = "SELECT s FROM SongAlbum s"),
    @NamedQuery(name = "SongAlbum.findBySongalbumid", query = "SELECT s FROM SongAlbum s WHERE s.songAlbumID = :songAlbumID")})
public class SongAlbum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SONGALBUMID")
    private Long songAlbumID;
    @JoinColumn(name = "ALBUMID", referencedColumnName = "ALBUMID")
    @ManyToOne(optional = false)
    private Album albumID;

    public SongAlbum() {
    }

    public SongAlbum(Long songAlbumID) {
        this.songAlbumID = songAlbumID;
    }

    public Long getSongalbumid() {
        return songAlbumID;
    }

    public void setSongalbumid(Long songAlbumID) {
        this.songAlbumID = songAlbumID;
    }

    public Album getAlbumid() {
        return albumID;
    }

    public void setAlbumid(Album albumID) {
        this.albumID = albumID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (songAlbumID != null ? songAlbumID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SongAlbum)) {
            return false;
        }
        SongAlbum other = (SongAlbum) object;
        if ((this.songAlbumID == null && other.songAlbumID != null) || (this.songAlbumID != null && !this.songAlbumID.equals(other.songAlbumID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "radiostation.SongAlbum[ songAlbumID=" + songAlbumID + " ]";
    }

}
