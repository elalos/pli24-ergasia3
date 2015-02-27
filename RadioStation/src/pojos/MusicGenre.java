package pojos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "MUSICGENRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MusicGenre.findAll", query = "SELECT m FROM MusicGenre m"),
    @NamedQuery(name = "MusicGenre.findByMusicgenreid", query = "SELECT m FROM MusicGenre m WHERE m.musicgenreid = :musicgenreid"),
    @NamedQuery(name = "MusicGenre.findByName", query = "SELECT m FROM MusicGenre m WHERE m.name = :name")})
public class MusicGenre implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MUSICGENREID")
    private Long musicgenreid;
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "musicgenreid")
    private List<Artist> artistList;

    public MusicGenre() {
    }

    public MusicGenre(Long musicgenreid) {
        this.musicgenreid = musicgenreid;
    }

    public Long getMusicgenreid() {
        return musicgenreid;
    }

    public void setMusicgenreid(Long musicgenreid) {
        Long oldMusicgenreid = this.musicgenreid;
        this.musicgenreid = musicgenreid;
        changeSupport.firePropertyChange("musicgenreid", oldMusicgenreid, musicgenreid);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    @XmlTransient
    public List<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (musicgenreid != null ? musicgenreid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicGenre)) {
            return false;
        }
        MusicGenre other = (MusicGenre) object;
        if ((this.musicgenreid == null && other.musicgenreid != null) || (this.musicgenreid != null && !this.musicgenreid.equals(other.musicgenreid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.MusicGenre[ musicgenreid=" + musicgenreid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
