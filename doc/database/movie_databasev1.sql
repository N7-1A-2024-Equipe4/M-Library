DROP
DATABASE IF EXISTS mlibrary;

CREATE
DATABASE mlibrary;

USE
mlibrary;

DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS list;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS actor;
DROP TABLE IF EXISTS screenwriter;
DROP TABLE IF EXISTS director;
DROP TABLE IF EXISTS actor_in_movie;
DROP TABLE IF EXISTS movie_in_list;

CREATE TABLE user
(
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL
);

CREATE TABLE list
(
    list_id INT AUTO_INCREMENT PRIMARY KEY,
    list_name VARCHAR(255) NOT NULL,
    icon LONGBLOB,
    creation_date DATE NOT NULL,
    user_id INT,
    description TEXT(1000),
    FOREIGN KEY (user_id) REFERENCES user (user_id)
);

CREATE TABLE person
(
    person_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    date_of_birth DATE NOT NULL,
    date_of_death DATE,
    is_actor BOOL,
    is_director BOOL,
    is_screenwriter BOOL
);

CREATE TABLE movie
(
    movie_id    INT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    genre       ENUM('Action', 'Comedy', 'Drama', 'Horror', 'Romance', 'Sci-Fi', 'Documentary', 'Fantasy', 'Thriller', 'War'),
    duration    INT,
    image       LONGBLOB, -- Since this database will be used for a small application, we choose to store the image directly in the database
    synopsis    TEXT(1000) NOT NULL,
    person_id INT,
    FOREIGN KEY (person_id) REFERENCES person (person_id)
);

CREATE TABLE review
(
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    review    TEXT(1000) NOT NULL,
    user_id   INT,
    movie_id  INT,
    FOREIGN KEY (user_id) REFERENCES user (user_id),
    FOREIGN KEY (movie_id) REFERENCES movie (movie_id)
);

CREATE TABLE actor_in_movie
(
    actor_in_movie_id INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT,
    movie_id INT,
    FOREIGN KEY (person_id) REFERENCES person (person_id),
    FOREIGN KEY (movie_id) REFERENCES movie (movie_id)
);

CREATE TABLE director_of_movie
(
    director_in_movie_id INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT,
    movie_id INT,
    FOREIGN KEY (person_id) REFERENCES person (person_id),
    FOREIGN KEY (movie_id) REFERENCES movie (movie_id)
);

CREATE TABLE movie_in_list
(
    movie_id INT,
    list_id INT,
    note VARCHAR(255),
    FOREIGN KEY (movie_id) REFERENCES movie (movie_id),
    FOREIGN KEY (list_id) REFERENCES list (list_id)
);