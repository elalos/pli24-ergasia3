package pojos;

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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "PLAYLIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlayList.findAll", query = "SELECT p FROM PlayList p"),
    @NamedQuery(name = "PlayList.findByPlaylistid", query = "SELECT p FROM PlayList p WHERE p.playlistid = :playlistid"),
    @NamedQuery(name = "PlayList.findByName", query = "SELECT p FROM PlayList p WHERE p.name = :name"),
    @NamedQuery(name = "PlayList.findByCreationdate", query = "SELECT p FROM PlayList p WHERE p.creationdate = :creationdate")})
public class PlayList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PLAYLISTID")
    private Long playlistid;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CREATIONDATE")
    private String creationdate;

    public PlayList() {
    }

    public PlayList(Long playlistid) {
        this.playlistid = playlistid;
    }

    public Long getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(Long playlistid) {
        this.playlistid = playlistid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playlistid != null ? playlistid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlayList)) {
            return false;
        }
        PlayList other = (PlayList) object;
        if ((this.playlistid == null && other.playlistid != null) || (this.playlistid != null && !this.playlistid.equals(other.playlistid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.PlayList[ playlistid=" + playlistid + " ]";
    }

}
