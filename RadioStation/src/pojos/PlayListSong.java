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
@Table(name = "PLAYLISTSONG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlayListSong.findAll", query = "SELECT p FROM PlayListSong p"),
    @NamedQuery(name = "PlayListSong.findByPlaylistsongid", query = "SELECT p FROM PlayListSong p WHERE p.playlistsongid = :playlistsongid")})
public class PlayListSong implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PLAYLISTSONGID")
    private Long playlistsongid;
    @JoinColumn(name = "PLAYLISTID", referencedColumnName = "PLAYLISTID")
    @ManyToOne
    private PlayList playlistid;
    @JoinColumn(name = "SONGID", referencedColumnName = "SONGID")
    @ManyToOne
    private Song songid;

    public PlayListSong() {
    }

    public PlayListSong(Long playlistsongid) {
        this.playlistsongid = playlistsongid;
    }

    public Long getPlaylistsongid() {
        return playlistsongid;
    }

    public void setPlaylistsongid(Long playlistsongid) {
        this.playlistsongid = playlistsongid;
    }

    public PlayList getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(PlayList playlistid) {
        this.playlistid = playlistid;
    }

    public Song getSongid() {
        return songid;
    }

    public void setSongid(Song songid) {
        this.songid = songid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playlistsongid != null ? playlistsongid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlayListSong)) {
            return false;
        }
        PlayListSong other = (PlayListSong) object;
        if ((this.playlistsongid == null && other.playlistsongid != null) || (this.playlistsongid != null && !this.playlistsongid.equals(other.playlistsongid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.PlayListSong[ playlistsongid=" + playlistsongid + " ]";
    }

}
