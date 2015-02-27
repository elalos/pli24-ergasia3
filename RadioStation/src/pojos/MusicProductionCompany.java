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
@Table(name = "MUSICPRODUCTIONCOMPANY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MusicProductionCompany.findAll", query = "SELECT m FROM MusicProductionCompany m"),
    @NamedQuery(name = "MusicProductionCompany.findByMusicproductioncompanyid", query = "SELECT m FROM MusicProductionCompany m WHERE m.musicproductioncompanyid = :musicproductioncompanyid"),
    @NamedQuery(name = "MusicProductionCompany.findByName", query = "SELECT m FROM MusicProductionCompany m WHERE m.name = :name"),
    @NamedQuery(name = "MusicProductionCompany.findByAddress", query = "SELECT m FROM MusicProductionCompany m WHERE m.address = :address"),
    @NamedQuery(name = "MusicProductionCompany.findByTelephone", query = "SELECT m FROM MusicProductionCompany m WHERE m.telephone = :telephone")})
public class MusicProductionCompany implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MUSICPRODUCTIONCOMPANYID")
    private Long musicproductioncompanyid;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "TELEPHONE")
    private String telephone;
    @OneToMany(mappedBy = "musicproductioncompanyid")
    private List<Album> albumList;

    public MusicProductionCompany() {
    }

    public MusicProductionCompany(Long musicproductioncompanyid) {
        this.musicproductioncompanyid = musicproductioncompanyid;
    }

    public Long getMusicproductioncompanyid() {
        return musicproductioncompanyid;
    }

    public void setMusicproductioncompanyid(Long musicproductioncompanyid) {
        this.musicproductioncompanyid = musicproductioncompanyid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
        hash += (musicproductioncompanyid != null ? musicproductioncompanyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicProductionCompany)) {
            return false;
        }
        MusicProductionCompany other = (MusicProductionCompany) object;
        if ((this.musicproductioncompanyid == null && other.musicproductioncompanyid != null) || (this.musicproductioncompanyid != null && !this.musicproductioncompanyid.equals(other.musicproductioncompanyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.MusicProductionCompany[ musicproductioncompanyid=" + musicproductioncompanyid + " ]";
    }

}
