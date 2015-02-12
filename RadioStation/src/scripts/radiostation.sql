/* Διαγραφή πινάκων */

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
    CONSTRAINT musicGenreFK FOREIGN KEY (musicGenreID)
        REFERENCES MusicGenre(musicGenreID)
);

CREATE TABLE MusicGroup (
    musicGroupID BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(100) NOT NULL,
    formationDate TIMESTAMP NOT NULL,
    artistID BIGINT NOT NULL,
    CONSTRAINT artistFK FOREIGN KEY (artistID)
        REFERENCES Artist(artistID)
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
    CONSTRAINT musicProductionCompanyFK FOREIGN KEY (musicProductionCompanyID) 
        REFERENCES MusicProductionCompany(musicProductionCompanyID),
    CONSTRAINT artistAlbumFK FOREIGN KEY (artistID) 
        REFERENCES Artist(artistID),
    CONSTRAINT musicGroupFK FOREIGN KEY (musicGroupID) 
        REFERENCES MusicGroup(musicGroupID),
    CONSTRAINT songFK FOREIGN KEY (songID) 
        REFERENCES Song(songID)
);

CREATE TABLE PlayList (
    playListID BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(255) NOT NULL,
    songID BIGINT NOT NULL,
    CONSTRAINT songPlayListFK FOREIGN KEY (songID) 
        REFERENCES Song(songID)
);