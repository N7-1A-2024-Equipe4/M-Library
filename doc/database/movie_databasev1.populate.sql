SET SQL_SAFE_UPDATES = 0;

DELETE FROM director_of_movie;
DELETE FROM screenwriter_of_movie;
DELETE FROM movie_in_library;
DELETE FROM actor_in_movie;
DELETE FROM review;
DELETE FROM movie;
DELETE FROM person;
DELETE FROM library;
DELETE FROM user;

-- Insert sample users
INSERT INTO user (user_id, username)
VALUES
(1, 'john_doe'),
(2, 'jane_smith');

-- Insert sample lists
INSERT INTO library (library_id, library_name, icon, creation_date, user_id, description)
VALUES
(1, 'Favorites', 'heart.png', '2024-01-01', 1, 'My favorite movies'),
(2, 'Watch Later', 'clock.png', '2024-02-01', 2, 'Movies to watch later');

-- Insert sample people
INSERT INTO person (person_id, first_name, last_name, date_of_birth, date_of_death)
VALUES
(1, 'Leonardo', 'DiCaprio', '1974-11-11', NULL),
(2, 'Keanu', 'Reeves', '1964-09-02', NULL),
(3, 'Christopher', 'Nolan', '1970-07-30', NULL),
(4, 'Francis', 'Coppola', '1939-04-07', NULL),
(5, 'Quentin', 'Tarantino', '1963-03-27', NULL),
(6, 'Robert', 'Zemeckis', '1952-05-14', NULL),
(7, 'Frank', 'Darabont', '1959-01-28', NULL),
(8, 'Peter', 'Jackson', '1961-10-31', NULL),
(9, 'David', 'Fincher', '1962-08-28', NULL),
(10, 'Ridley', 'Scott', '1937-11-30', NULL),
(11, 'James', 'Cameron', '1954-08-16', NULL),
(12, 'Steven', 'Spielberg', '1946-12-18', NULL),
(13, 'Joss', 'Whedon', '1964-06-23', NULL),
(14, 'Jonathan', 'Demme', '1944-02-22', '2017-04-26'),
(15, 'Mel', 'Gibson', '1956-01-03', NULL),
(16, 'Cillian', 'Murphy', '1976-05-25', NULL),
(17, 'Joseph', 'Gordon-Levitt', '1981-02-17', NULL),
(18, 'Tom', 'Hardy', '1977-09-15', NULL),
(19, 'Al', 'Pacino', '1940-04-25', NULL),
(20, 'Marlon', 'Brando', '1924-04-03', '2004-07-01'),
(21, 'James', 'Caan', '1940-03-26', '2022-07-06'),
(22, 'Diane', 'Keaton', '1946-01-05', NULL),
(23, 'Ema', 'Thurman', '1970-04-25', NULL),
(24, 'James', 'Caan', '1954-02-18', NULL),
(25, 'Samuel L.', 'Jackson', '1948-12-21', NULL),
(26, 'Heath', 'Ledger', '1979-04-04', '2008-01-22'),
(27, 'Tom', 'Hanks', '1956-07-09', NULL),
(28, 'Robin', 'Wright', '1966-04-08', NULL),
(29, 'Morgan', 'Freeman', '1937-06-01', NULL),
(30, 'Tim', 'Robbins', '1958-10-16', NULL),
(31, 'Elijah', 'Wood', '1981-01-28', NULL),
(32, 'Ian', 'McKellen', '1939-05-25', NULL),
(33, 'Cate', 'Blanchett', '1969-05-14', NULL),
(34, 'Edward', 'Norton', '1969-08-18', NULL),
(35, 'Brad', 'Pitt', '1963-12-18', NULL),
(36, 'Helena', 'Bonham Carter', '1966-05-26', NULL),
(37, 'Matthew', 'McConaughey', '1969-11-04', NULL),
(38, 'Jessica', 'Chastain', '1977-03-24', NULL),
(39, 'Anne', 'Hathaway', '1982-11-12', NULL),
(40, 'Russell', 'Crowe', '1964-04-07', NULL),
(41, 'Joaquin', 'Phoenix', '1974-10-28', NULL),
(42, 'Connie', 'Nielsen', '1965-07-03', NULL),
(43, 'Kate', 'Winslet', '1975-10-05', NULL),
(44, 'Jodie', 'Foster', '1962-11-19', NULL),
(45, 'Anthony', 'Hopkins', '1937-12-31', NULL),
(46, 'Sophie', 'Marceau', '1966-11-17', NULL),
(47, 'Catherine', 'McCormack', '1972-04-03', NULL),
(48, 'Michael', 'Clarke Duncan', '1957-12-10', '2012-09-03');

-- Insert sample movies
INSERT INTO movie (movie_id, title, genre, duration, image, synopsis, rating)
VALUES (1, 'Inception', 'Sci-Fi', 148, NULL,
        'A thief who steals corporate secrets through the use of dream-sharing technology.', 0),
       (2, 'The Godfather', 'Drama', 175, NULL,
        'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.'
        , 0),
       (3, 'Pulp Fiction', 'Comedy', 154, NULL,
        'The lives of two mob hitmen, a boxer, a gangster, and his wife intertwine in four tales of violence and redemption.'
        , 0),
       (4, 'The Dark Knight', 'Action', 152, NULL,
        'When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.'
        , 0),
       (5, 'Forrest Gump', 'Drama', 142, NULL,
        'The presidencies of Kennedy and Johnson, the events of Vietnam, Watergate, and other history unfold through the perspective of an Alabama man with an IQ of 75.'
        , 0),
       (6, 'The Shawshank Redemption', 'Drama', 142, NULL,
        'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.'
        , 0),
       (7, 'The Lord of the Rings: The Fellowship of the Ring', 'Fantasy', 178, NULL,
        'A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.'
        , 0),
       (8, 'Fight Club', 'Drama', 139, NULL,
        'An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.'
        , 0),
       (9, 'Interstellar', 'Sci-Fi', 169, NULL,
        'A team of explorers travel through a wormhole in space in an attempt to ensure humanity''s survival.'
        , 0),
       (10, 'Gladiator', 'Action', 155, NULL,
        'A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery.'
        , 0),
       (11, 'Titanic', 'Drama', 195, NULL,
        'A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.'
        , 0),
       (12, 'The Silence of the Lambs', 'Thriller', 118, NULL,
        'A young F.B.I. cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.'
        , 0),
       (13, 'Braveheart', 'Action', 178, NULL,
        'Scottish warrior William Wallace leads his countrymen in a rebellion to free his homeland from the tyranny of King Edward I of England.'
        , 0),
       (14, 'The Green Mile', 'Drama', 189, NULL,
        'The lives of guards on Death Row are affected by one of their charges: a black man accused of child murder and rape, yet who has a mysterious gift.'
        , 0);

-- Insert sample reviews
INSERT INTO review (review_id, movie_id, user_id, review)
VALUES (1, 1, 1, 'Amazing movie with a mind-blowing plot!'),
       (2, 2, 2, 'A revolutionary film with great special effects.');

-- Insert sample castings
INSERT INTO actor_in_movie (movie_id, person_id)
VALUES
(1, 1),
(1, 16),
(1, 17),
(1, 18),
(2, 19),
(2, 20),
(2, 21),
(2, 22),
(3, 23),
(3, 24),
(3, 25),
(4, 26),
(5, 27),
(5, 28),
(6, 29),
(6, 30),
(7, 31),
(7, 32),
(7, 33),
(8, 34),
(8, 35),
(8, 36),
(9, 37),
(9, 38),
(9, 39),
(10, 40),
(10, 41),
(10, 42),
(11, 43),
(11, 1),
(12, 44),
(12, 45),
(13, 15),
(13, 46),
(13, 47),
(14, 48),
(14, 27);

-- Insert sample directors
INSERT INTO director_of_movie (movie_id, person_id)
VALUES
(1, 3),
(3, 5);

-- Insert sample saved lists
INSERT INTO movie_in_library (movie_id, library_id, note)
VALUES
(1, 1, 'Good movie'),
(2, 1, 'Wow !');
