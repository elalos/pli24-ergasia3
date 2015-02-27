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
@Table(name = "MUSICGROUPARTIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MusicGroupArtist.findAll", query = "SELECT m FROM MusicGroupArtist m"),
    @NamedQuery(name = "MusicGroupArtist.findByMusicgroupartistid", query = "SELECT m FROM MusicGroupArtist m WHERE m.musicgroupartistid = :musicgroupartistid")})
public class MusicGroupArtist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MUSICGROUPARTISTID")
    private Long musicgroupartistid;
    @JoinColumn(name = "ARTISTID", referencedColumnName = "ARTISTID")
    @ManyToOne
    private Artist artistid;
    @JoinColumn(name = "MUSICGROUPID", referencedColumnName = "MUSICGROUPID")
    @ManyToOne
    private MusicGroup musicgroupid;

    public MusicGroupArtist() {
    }

    public MusicGroupArtist(Long musicgroupartistid) {
        this.musicgroupartistid = musicgroupartistid;
    }

    public Long getMusicgroupartistid() {
        return musicgroupartistid;
    }

    public void setMusicgroupartistid(Long musicgroupartistid) {
        this.musicgroupartistid = musicgroupartistid;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (musicgroupartistid != null ? musicgroupartistid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicGroupArtist)) {
            return false;
        }
        MusicGroupArtist other = (MusicGroupArtist) object;
        if ((this.musicgroupartistid == null && other.musicgroupartistid != null) || (this.musicgroupartistid != null && !this.musicgroupartistid.equals(other.musicgroupartistid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.MusicGroupArtist[ musicgroupartistid=" + musicgroupartistid + " ]";
    }

}
