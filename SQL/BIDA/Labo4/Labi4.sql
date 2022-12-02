USE master
CREATE DATABASE [StackOverflow] ON
(FILENAME = N'/tmp/StackOverflow2010.mdf'),
(FILENAME= N'/tmp/StackOverflow2010_log.ldf')
FOR ATTACH;

CREATE DATABASE Labo4;
Use Labo4;

CREATE TABLE users(
    id int PRIMARY KEY IDENTITY,
    pseudo VarChar(50) NOT NULL,
    city VarChar(50) NOT NULL,
    webSiteUrl VarChar(50),
);

CREATE TABLE comment (
    Id int PRIMARY KEY IDENTITY,
    Author VarChar(50) NOT NULL,
);

CREATE TABLE question(
    Id int PRIMARY KEY IDENTITY,
    CreationDate DateTime NOT NULL,
    ViewsCount int NOT NULL,
    FavoriteCount int NOT NULL,
    Answer int FOREIGN KEY REFERENCES comment(Id),
    Author int FOREIGN KEY REFERENCES users(Id),
);
