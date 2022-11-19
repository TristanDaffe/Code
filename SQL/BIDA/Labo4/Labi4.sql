CREATE DATABASE [StackOverflow] ON
(name= so1, FILENAME = N'/tmp/StackOverflow2010.mdf')
LOG ON (FILENAME='/tmp/StackOverflow2010.ldf')
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
