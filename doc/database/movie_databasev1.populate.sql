SET SQL_SAFE_UPDATES = 0;

DELETE FROM movie_in_list;
DELETE FROM actor_in_movie;
DELETE FROM review;
DELETE FROM movie;
DELETE FROM person;
DELETE FROM list;
DELETE FROM user;

-- Insert sample users
INSERT INTO user (username)
VALUES
('john_doe'),
('jane_smith');

-- Insert sample lists
-- INSERT INTO list (list_name, icon, creation_date, user_id, description)
-- VALUES
-- ('Favorites', 'heart.png', '2024-01-01', 1, 'My favorite movies'),
-- ('Watch Later', 'clock.png', '2024-02-01', 2, 'Movies to watch later');

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
(16, 'Cillian', 'Murphy', '1976-05-25', NULL);
(17, 'Joseph', 'Gordon-Levitt', '1981-02-17', NULL);
(18, 'Tom', 'Hardy', '1977-09-15', NULL);
(19, 'Al', 'Pacino', '1940-04-25', NULL),
(20, 'Marlon', 'Brando', '1924-04-03', '2004-07-01');
(21, 'James', 'Caan', '1940-03-26', '2022-07-06');
(22, 'Diane', 'Keaton', '1946-01-05', NULL);
(23, 'Ema', 'Thurman', '1970-04-25', NULL;
(24, 'James', 'Caan', '1954-02-18', NULL);
(25, 'Samuel L.', 'Jackson', '1948-12-21', NULL);
(26, 'Heath', 'Ledger', '1979-04-04', '2008-01-22');
(27, 'Tom', 'Hanks', '1956-07-09', NULL);
(28, 'Robin', 'Wright', '1966-04-08', NULL);

-- Insert sample movies
INSERT INTO movie (title, genre, duration, image, synopsis, person_id)
VALUES ('Inception', 'Sci-Fi', 148, NULL,
        'A thief who steals corporate secrets through the use of dream-sharing technology.', 3),
       ('The Godfather', 'Drama', 175, NULL,
        'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.',
        4),
       ('Pulp Fiction', 'Comedy', 154, NULL,
        'The lives of two mob hitmen, a boxer, a gangster, and his wife intertwine in four tales of violence and redemption.',
        5),
       ('The Dark Knight', 'Action', 152, NULL,
        'When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.',
        3),
       ('Forrest Gump', 'Drama', 142, NULL,
        'The presidencies of Kennedy and Johnson, the events of Vietnam, Watergate, and other history unfold through the perspective of an Alabama man with an IQ of 75.',
        6),
       ('The Shawshank Redemption', 'Drama', 142, NULL,
        'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.',
        7),
       ('The Lord of the Rings: The Fellowship of the Ring', 'Fantasy', 178, NULL,
        'A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.',
        8),
       ('Fight Club', 'Drama', 139, NULL,
        'An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.',
        9),
       ('Interstellar', 'Sci-Fi', 169, NULL,
        'A team of explorers travel through a wormhole in space in an attempt to ensure humanity''s survival.',
        3),
       ('Gladiator', 'Action', 155, NULL,
        'A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery.',
        10),
       ('Titanic', 'Drama', 195, NULL,
        'A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.',
        11),
       ('Jurassic Park', 'Sci-Fi', 127, NULL,
        'A pragmatic paleontologist visiting an almost complete theme park is tasked with protecting a couple of kids after a power failure causes the park''s cloned dinosaurs to run loose.',
        12),
       ('The Avengers', 'Action', 143, NULL,
        'Earth''s mightiest heroes must come together and learn to fight as a team if they are to stop the mischievous Loki and his alien army from enslaving humanity.',
        13),
       ('Back to the Future', 'Sci-Fi', 116, NULL,
        'Marty McFly, a 17-year-old high school student, is accidentally sent 30 years into the past in a time-traveling DeLorean invented by his close friend, eccentric scientist Doc Brown.',
        6),
       ('The Silence of the Lambs', 'Thriller', 118, NULL,
        'A young F.B.I. cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.',
        14),
       ('Schindler''s List', 'Drama', 195, NULL,
        'In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.',
        12),
       ('Braveheart', 'Action', 178, NULL,
        'Scottish warrior William Wallace leads his countrymen in a rebellion to free his homeland from the tyranny of King Edward I of England.',
        15),
       ('The Green Mile', 'Drama', 189, NULL,
        'The lives of guards on Death Row are affected by one of their charges: a black man accused of child murder and rape, yet who has a mysterious gift.',
        7),
       ('Saving Private Ryan', 'War', 169, NULL,
        'Following the Normandy Landings, a group of U.S. soldiers go behind enemy lines to retrieve a paratrooper whose brothers have been killed in action.',
        12);

-- Insert sample reviews
-- INSERT INTO review (movie_id, user_id, review)
-- VALUES (1, 1, 'Amazing movie with a mind-blowing plot!'),
--       (2, 2, 'A revolutionary film with great special effects.');

-- Insert sample castings
INSERT INTO actor_in_movie (actor_in_movie_id, movie_id, person_id)
VALUES
(1, 1, 1),
(2, 1, 16),
(3, 1, 17),
(4, 1, 18),

(9, 2, 19),
(10, 2, 20),
(11, 2, 21),
(12, 2, 22),

(13, 3, 23),
(14, 3, 24),
(15, 3, 25),

(16, 4, 26),

(17, 5, 27),
(18, 5, 28);





-- Insert sample directors
INSERT INTO director_of_movie (director_in_movie_id, movie_id, person_id)
VALUES
(1, 1, 3),
(2, 3, 5);

-- Insert sample saved lists
-- INSERT INTO movie_in_list (movie_id, list_id)
-- VALUES
-- (1, 1),
-- (2, 2);
