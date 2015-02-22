package pojos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "MUSICGROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MusicGroup.findAll", query = "SELECT m FROM MusicGroup m"),
    @NamedQuery(name = "MusicGroup.findByMusicgroupid", query = "SELECT m FROM MusicGroup m WHERE m.musicGroupID = :musicGroupID"),
    @NamedQuery(name = "MusicGroup.findByName", query = "SELECT m FROM MusicGroup m WHERE m.name = :name"),
    @NamedQuery(name = "MusicGroup.findByFormationdate", query = "SELECT m FROM MusicGroup m WHERE m.formationDate = :formationDate")})
public class MusicGroup implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MUSICGROUPID")
    private Long musicGroupID;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "FORMATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date formationDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "musicGroupID")
    private List<ArtistMusicGroup> artistMusicGroupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "musicGroupID")
    private List<Album> albumList;

    public MusicGroup() {
    }

    public MusicGroup(Long musicGroupID) {
        this.musicGroupID = musicGroupID;
    }

    public MusicGroup(Long musicGroupID, String name, Date formationDate) {
        this.musicGroupID = musicGroupID;
        this.name = name;
        this.formationDate = formationDate;
    }

    public Long getMusicgroupid() {
        return musicGroupID;
    }

    public void setMusicgroupid(Long musicGroupID) {
        this.musicGroupID = musicGroupID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public Date getFormationdate() {
        return formationDate;
    }

    public void setFormationdate(Date formationDate) {
        this.formationDate = formationDate;
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
        hash += (musicGroupID != null ? musicGroupID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicGroup)) {
            return false;
        }
        MusicGroup other = (MusicGroup) object;
        if ((this.musicGroupID == null && other.musicGroupID != null) || (this.musicGroupID != null && !this.musicGroupID.equals(other.musicGroupID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "radiostation.MusicGroup[ musicGroupID=" + musicGroupID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
