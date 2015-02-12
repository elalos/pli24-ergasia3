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
@Table(name = "SONGPLAYLIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SongPlayList.findAll", query = "SELECT s FROM SongPlayList s"),
    @NamedQuery(name = "SongPlayList.findBySongplaylistid", query = "SELECT s FROM SongPlayList s WHERE s.songPlayListID = :songPlayListID")})
public class SongPlayList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SONGPLAYLISTID")
    private Long songPlayListID;
    @JoinColumn(name = "PLAYLISTID", referencedColumnName = "PLAYLISTID")
    @ManyToOne(optional = false)
    private PlayList playListID;

    public SongPlayList() {
    }

    public SongPlayList(Long songPlayListID) {
        this.songPlayListID = songPlayListID;
    }

    public Long getSongplaylistid() {
        return songPlayListID;
    }

    public void setSongplaylistid(Long songPlayListID) {
        this.songPlayListID = songPlayListID;
    }

    public PlayList getPlaylistid() {
        return playListID;
    }

    public void setPlaylistid(PlayList playListID) {
        this.playListID = playListID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (songPlayListID != null ? songPlayListID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SongPlayList)) {
            return false;
        }
        SongPlayList other = (SongPlayList) object;
        if ((this.songPlayListID == null && other.songPlayListID != null) || (this.songPlayListID != null && !this.songPlayListID.equals(other.songPlayListID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "radiostation.SongPlayList[ songPlayListID=" + songPlayListID + " ]";
    }

}
