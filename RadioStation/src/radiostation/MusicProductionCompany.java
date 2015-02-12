package radiostation;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "MUSICPRODUCTIONCOMPANY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MusicProductionCompany.findAll", query = "SELECT m FROM MusicProductionCompany m"),
    @NamedQuery(name = "MusicProductionCompany.findByMusicproductioncompanyid", query = "SELECT m FROM MusicProductionCompany m WHERE m.musicProductionCompanyID = :musicProductionCompanyID"),
    @NamedQuery(name = "MusicProductionCompany.findByName", query = "SELECT m FROM MusicProductionCompany m WHERE m.name = :name"),
    @NamedQuery(name = "MusicProductionCompany.findByAddress", query = "SELECT m FROM MusicProductionCompany m WHERE m.address = :address"),
    @NamedQuery(name = "MusicProductionCompany.findByTelephone", query = "SELECT m FROM MusicProductionCompany m WHERE m.telephone = :telephone")})
public class MusicProductionCompany implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MUSICPRODUCTIONCOMPANYID")
    private Long musicProductionCompanyID;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @Column(name = "TELEPHONE")
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "musicProductionCompanyID")
    private List<Album> albumList;

    public MusicProductionCompany() {
    }

    public MusicProductionCompany(Long musicProductionCompanyID) {
        this.musicProductionCompanyID = musicProductionCompanyID;
    }

    public MusicProductionCompany(Long musicProductionCompanyID, String name, String address, String telephone) {
        this.musicProductionCompanyID = musicProductionCompanyID;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }

    public Long getMusicproductioncompanyid() {
        return musicProductionCompanyID;
    }

    public void setMusicproductioncompanyid(Long musicProductionCompanyID) {
        this.musicProductionCompanyID = musicProductionCompanyID;
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
        hash += (musicProductionCompanyID != null ? musicProductionCompanyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicProductionCompany)) {
            return false;
        }
        MusicProductionCompany other = (MusicProductionCompany) object;
        if ((this.musicProductionCompanyID == null && other.musicProductionCompanyID != null) || (this.musicProductionCompanyID != null && !this.musicProductionCompanyID.equals(other.musicProductionCompanyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "radiostation.MusicProductionCompany[ musicProductionCompanyID=" + musicProductionCompanyID + " ]";
    }

}
