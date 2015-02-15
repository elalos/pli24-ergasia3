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
@Table(name = "ARTISTMUSICGROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArtistMusicGroup.findAll", query = "SELECT a FROM ArtistMusicGroup a"),
    @NamedQuery(name = "ArtistMusicGroup.findByArtistmusicgroupid", query = "SELECT a FROM ArtistMusicGroup a WHERE a.artistMusicGroupID = :artistMusicGroupID")})
public class ArtistMusicGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ARTISTMUSICGROUPID")
    private Long artistMusicGroupID;
    @JoinColumn(name = "ARTISTID", referencedColumnName = "ARTISTID")
    @ManyToOne(optional = false)
    private Artist artistID;
    @JoinColumn(name = "MUSICGROUPID", referencedColumnName = "MUSICGROUPID")
    @ManyToOne(optional = false)
    private MusicGroup musicGroupID;

    public ArtistMusicGroup() {
    }

    public ArtistMusicGroup(Long artistMusicGroupID) {
        this.artistMusicGroupID = artistMusicGroupID;
    }

    public Long getArtistmusicgroupid() {
        return artistMusicGroupID;
    }

    public void setArtistmusicgroupid(Long artistMusicGroupID) {
        this.artistMusicGroupID = artistMusicGroupID;
    }

    public Artist getArtistid() {
        return artistID;
    }

    public void setArtistid(Artist artistID) {
        this.artistID = artistID;
    }

    public MusicGroup getMusicgroupid() {
        return musicGroupID;
    }

    public void setMusicgroupid(MusicGroup musicGroupID) {
        this.musicGroupID = musicGroupID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artistMusicGroupID != null ? artistMusicGroupID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArtistMusicGroup)) {
            return false;
        }
        ArtistMusicGroup other = (ArtistMusicGroup) object;
        if ((this.artistMusicGroupID == null && other.artistMusicGroupID != null) || (this.artistMusicGroupID != null && !this.artistMusicGroupID.equals(other.artistMusicGroupID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "radiostation.ArtistMusicGroup[ artistMusicGroupID=" + artistMusicGroupID + " ]";
    }

}
