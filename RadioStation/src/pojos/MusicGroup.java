package pojos;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "MUSICGROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MusicGroup.findAll", query = "SELECT m FROM MusicGroup m"),
    @NamedQuery(name = "MusicGroup.findByMusicgroupid", query = "SELECT m FROM MusicGroup m WHERE m.musicgroupid = :musicgroupid"),
    @NamedQuery(name = "MusicGroup.findByName", query = "SELECT m FROM MusicGroup m WHERE m.name = :name"),
    @NamedQuery(name = "MusicGroup.findByFormationdate", query = "SELECT m FROM MusicGroup m WHERE m.formationdate = :formationdate")})
public class MusicGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MUSICGROUPID")
    private Long musicgroupid;
    @Column(name = "NAME")
    private String name;
    @Column(name = "FORMATIONDATE")
    private String formationdate;
    @OneToMany(mappedBy = "musicgroupid")
    private List<Album> albumList;
    @OneToMany(mappedBy = "musicgroupid")
    private List<MusicGroupArtist> musicGroupArtistList;

    public MusicGroup() {
    }

    public MusicGroup(Long musicgroupid) {
        this.musicgroupid = musicgroupid;
    }

    public Long getMusicgroupid() {
        return musicgroupid;
    }

    public void setMusicgroupid(Long musicgroupid) {
        this.musicgroupid = musicgroupid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormationdate() {
        return formationdate;
    }

    public void setFormationdate(String formationdate) {
        this.formationdate = formationdate;
    }

    @XmlTransient
    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    @XmlTransient
    public List<MusicGroupArtist> getMusicGroupArtistList() {
        return musicGroupArtistList;
    }

    public void setMusicGroupArtistList(List<MusicGroupArtist> musicGroupArtistList) {
        this.musicGroupArtistList = musicGroupArtistList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (musicgroupid != null ? musicgroupid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicGroup)) {
            return false;
        }
        MusicGroup other = (MusicGroup) object;
        if ((this.musicgroupid == null && other.musicgroupid != null) || (this.musicgroupid != null && !this.musicgroupid.equals(other.musicgroupid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.MusicGroup[ musicgroupid=" + musicgroupid + " ]";
    }

}
