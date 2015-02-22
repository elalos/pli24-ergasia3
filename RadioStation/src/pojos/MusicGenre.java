package pojos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "MUSICGENRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MusicGenre.findAll", query = "SELECT m FROM MusicGenre m"),
    @NamedQuery(name = "MusicGenre.findByMusicgenreid", query = "SELECT m FROM MusicGenre m WHERE m.musicGenreID = :musicGenreID"),
    @NamedQuery(name = "MusicGenre.findByName", query = "SELECT m FROM MusicGenre m WHERE m.name = :name")})
public class MusicGenre implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MUSICGENREID")
    private Long musicGenreID;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;

    public MusicGenre() {
    }

    public MusicGenre(Long musicGenreID) {
        this.musicGenreID = musicGenreID;
    }

    public MusicGenre(Long musicGenreID, String name) {
        this.musicGenreID = musicGenreID;
        this.name = name;
    }

    public Long getMusicgenreid() {
        return musicGenreID;
    }

    public void setMusicgenreid(Long musicGenreID) {
        this.musicGenreID = musicGenreID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (musicGenreID != null ? musicGenreID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicGenre)) {
            return false;
        }
        MusicGenre other = (MusicGenre) object;
        if ((this.musicGenreID == null && other.musicGenreID != null) || (this.musicGenreID != null && !this.musicGenreID.equals(other.musicGenreID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "radiostation.MusicGenre[ musicGenreID=" + musicGenreID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
