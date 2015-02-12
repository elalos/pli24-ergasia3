/* Διαγραφή πινάκων */

DROP TABLE SongPlayList;
DROP TABLE SongAlbum;
DROP TABLE ArtistMusicGroup;
DROP TABLE PlayList;
DROP TABLE Album;
DROP TABLE MusicGroup;
DROP TABLE Artist;
DROP TABLE MusicGenre;
DROP TABLE MusicProductionCompany;
DROP TABLE Song;

/* Δημιουργία πινάκων */

CREATE TABLE MusicGenre (
    musicGenreID BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE MusicProductionCompany (
    MusicProductionCompanyID BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    telephone VARCHAR(50) NOT NULL
);

CREATE TABLE Song (
    songID BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    title VARCHAR(100) NOT NULL,
    duration BIGINT NOT NULL,
    trackNr BIGINT NOT NULL
);

CREATE TABLE Artist (
    artistID BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    artisticName VARCHAR(50) NOT NULL,
    sex VARCHAR(1) NOT NULL,
    birthDay TIMESTAMP NOT NULL,
    birthPlace VARCHAR(100) NOT NULL,
    musicGenreID BIGINT NOT NULL,
    CONSTRAINT musicGenreArtistFK FOREIGN KEY (musicGenreID)
        REFERENCES MusicGenre(musicGenreID)
);

CREATE TABLE MusicGroup (
    musicGroupID BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(100) NOT NULL,
    formationDate TIMESTAMP NOT NULL
);

CREATE TABLE ArtistMusicGroup (
    ArtistMusicGroupID BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    artistID BIGINT NOT NULL,
    musicGroupID BIGINT NOT NULL,
    CONSTRAINT artistArtistMusicGroupFK FOREIGN KEY (artistID)
        REFERENCES Artist(artistID),
    CONSTRAINT musicGroupArtistMusicGroupFK FOREIGN KEY (musicGroupID)
        REFERENCES MusicGroup(musicGroupID)
);

CREATE TABLE Album (
    albumID BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    title VARCHAR(100) NOT NULL,
    releaseDate TIMESTAMP NOT NULL,
    type VARCHAR(2) NOT NULL,
    diskNumber BIGINT NOT NULL,
    musicProductionCompanyID BIGINT NOT NULL,
    artistID BIGINT NOT NULL,
    musicGroupID BIGINT NOT NULL,
    songID BIGINT NOT NULL,
    CONSTRAINT musicProductionCompanyAlbumFK FOREIGN KEY (musicProductionCompanyID) 
        REFERENCES MusicProductionCompany(musicProductionCompanyID),
    CONSTRAINT artistAlbumFK FOREIGN KEY (artistID) 
        REFERENCES Artist(artistID),
    CONSTRAINT musicGroupAlbumFK FOREIGN KEY (musicGroupID) 
        REFERENCES MusicGroup(musicGroupID),
    CONSTRAINT songAlbumFK FOREIGN KEY (songID) 
        REFERENCES Song(songID)
);

CREATE TABLE SongAlbum (
    SongAlbumID BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    songID BIGINT NOT NULL,
    albumID BIGINT NOT NULL,
    CONSTRAINT songSongAlbumFK FOREIGN KEY (songID) 
        REFERENCES Song(songID),
    CONSTRAINT albumSongAlbumFK FOREIGN KEY (albumID) 
        REFERENCES Album(albumID)
);

CREATE TABLE PlayList (
    playListID BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE SongPlayList (
    SongPlayListID BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    songID BIGINT NOT NULL,
    playListID BIGINT NOT NULL,
    CONSTRAINT songSongPlayListFK FOREIGN KEY (songID) 
        REFERENCES Song(songID),
    CONSTRAINT playListSongPlayListFK FOREIGN KEY (playListID) 
        REFERENCES PlayList(playListID)
);