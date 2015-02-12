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
@Table(name = "PLAYLIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlayList.findAll", query = "SELECT p FROM PlayList p"),
    @NamedQuery(name = "PlayList.findByPlaylistid", query = "SELECT p FROM PlayList p WHERE p.playListID = :playListID"),
    @NamedQuery(name = "PlayList.findByName", query = "SELECT p FROM PlayList p WHERE p.name = :name")})
public class PlayList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PLAYLISTID")
    private Long playListID;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @JoinColumn(name = "SONGID", referencedColumnName = "SONGID")
    @ManyToOne(optional = false)
    private Song songID;

    public PlayList() {
    }

    public PlayList(Long playListID) {
        this.playListID = playListID;
    }

    public PlayList(Long playListID, String name) {
        this.playListID = playListID;
        this.name = name;
    }

    public Long getPlaylistid() {
        return playListID;
    }

    public void setPlaylistid(Long playListID) {
        this.playListID = playListID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Song getSongid() {
        return songID;
    }

    public void setSongid(Song songID) {
        this.songID = songID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playListID != null ? playListID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlayList)) {
            return false;
        }
        PlayList other = (PlayList) object;
        if ((this.playListID == null && other.playListID != null) || (this.playListID != null && !this.playListID.equals(other.playListID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "radiostation.PlayList[ playListID=" + playListID + " ]";
    }

}
