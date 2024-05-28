DROP DATABASE IF EXISTS movie_database;

CREATE DATABASE movie_database;

USE movie_database;

DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS lists;
DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS people;
DROP TABLE IF EXISTS actors;
DROP TABLE IF EXISTS screenwriters;
DROP TABLE IF EXISTS directors;
DROP TABLE IF EXISTS castings;
DROP TABLE IF EXISTS saved_lists;

CREATE TABLE movies (
    movie_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    genre ENUM('Action', 'Comedy', 'Drama', 'Horror', 'Romance', 'Sci-Fi', 'Documentary'),
    duration INT,
    image LONGBLOB, -- // Since this database will be used for a small application, we choose to store the image directly in the database
    synopsis TEXT(1000) NOT NULL
);

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL
);

CREATE TABLE lists (
    list_id INT AUTO_INCREMENT PRIMARY KEY,
    list_name VARCHAR(255) NOT NULL,
    icon LONGBLOB,
    creation_date DATE NOT NULL,
    user_id INT,
    description TEXT(1000),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE reviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    review TEXT(1000) NOT NULL,
    user_id INT,
    movie_id INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (movie_id) REFERENCES movies(movie_id)
);

CREATE TABLE people (
    person_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    date_of_birth DATE NOT NULL,
    date_of_death DATE
);

CREATE TABLE actors (
    actor_id INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT,
    FOREIGN KEY (person_id) REFERENCES people(person_id)
);

CREATE TABLE screenwriters (
    screenwriter_id INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT,
    FOREIGN KEY (person_id) REFERENCES people(person_id)
);

CREATE TABLE directors (
    director_id INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT,
    FOREIGN KEY (person_id) REFERENCES people(person_id)
);

CREATE TABLE castings (
    casting_id INT AUTO_INCREMENT PRIMARY KEY,
    actor_id INT,
    movie_id INT,
    FOREIGN KEY (actor_id) REFERENCES actors(actor_id),
    FOREIGN KEY (movie_id) REFERENCES movies(movie_id)
);

CREATE TABLE saved_lists (
    movie_id INT,
    list_id INT,
    FOREIGN KEY (movie_id) REFERENCES movies(movie_id),
    FOREIGN KEY (list_id) REFERENCES lists(list_id)
);