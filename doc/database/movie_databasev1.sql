DROP
DATABASE IF EXISTS mlibrary;

CREATE
DATABASE mlibrary;

USE
mlibrary;

DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS library;
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

CREATE TABLE library
(
    library_id INT AUTO_INCREMENT PRIMARY KEY,
    library_name VARCHAR(255) NOT NULL,
    icon LONGBLOB,
    creation_date DATE,
    user_id INT NOT NULL,
    description TEXT(1000),
    FOREIGN KEY (user_id) REFERENCES user (user_id)
);

CREATE TABLE person
(
    person_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    date_of_birth DATE,
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
    synopsis    TEXT(1000),
    rating INT,
    CHECK (rating BETWEEN 0 AND 10)
);

CREATE TABLE review
(
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    review    TEXT(1000) NOT NULL,
    user_id   INT NOT NULL,
    movie_id  INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user (user_id),
    FOREIGN KEY (movie_id) REFERENCES movie (movie_id)
);

CREATE TABLE actor_in_movie
(
    person_id INT,
    movie_id INT,
    FOREIGN KEY (person_id) REFERENCES person (person_id),
    FOREIGN KEY (movie_id) REFERENCES movie (movie_id)
);

CREATE TABLE director_of_movie
(
    person_id INT,
    movie_id INT,
    FOREIGN KEY (person_id) REFERENCES person (person_id),
    FOREIGN KEY (movie_id) REFERENCES movie (movie_id)
);

CREATE TABLE screenwriter_of_movie
(
    person_id INT,
    movie_id INT,
    FOREIGN KEY (person_id) REFERENCES person (person_id),
    FOREIGN KEY (movie_id) REFERENCES movie (movie_id)
);

CREATE TABLE movie_in_library
(
    movie_id INT,
    library_id INT,
    note VARCHAR(255),
    FOREIGN KEY (movie_id) REFERENCES movie (movie_id),
    FOREIGN KEY (library_id) REFERENCES library (library_id)
);