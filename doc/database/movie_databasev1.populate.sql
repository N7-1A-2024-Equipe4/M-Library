-- Insert sample movies
INSERT INTO movies (title, genre, duration, image, synopsis) VALUES
('Inception', 'Sci-Fi', 148, NULL, 'A thief who steals corporate secrets through the use of dream-sharing technology.'),
('The Matrix', 'Sci-Fi', 136, NULL, 'A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.'),
('The Godfather', 'Drama', 175, NULL, 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.'),
('Pulp Fiction', 'Comedy', 154, NULL, 'The lives of two mob hitmen, a boxer, a gangster, and his wife intertwine in four tales of violence and redemption.'),
('The Dark Knight', 'Action', 152, NULL, 'When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.');

-- Insert sample users
INSERT INTO users (username) VALUES
('john_doe'),
('jane_smith');

-- Insert sample lists
INSERT INTO lists (list_name, icon, creation_date, user_id, description) VALUES
('Favorites', 'heart.png', '2024-01-01', 1, 'My favorite movies'),
('Watch Later', 'clock.png', '2024-02-01', 2, 'Movies to watch later');

-- Insert sample reviews
INSERT INTO reviews (movie_id, user_id, review) VALUES
(1, 1, 'Amazing movie with a mind-blowing plot!'),
(2, 2, 'A revolutionary film with great special effects.');

-- Insert sample people
INSERT INTO people (first_name, last_name, date_of_birth, date_of_death) VALUES
('Leonardo', 'DiCaprio', '1974-11-11', NULL),
('Keanu', 'Reeves', '1964-09-02', NULL),
('Francis', 'Coppola', '1939-04-07', NULL);

-- Insert sample actors
INSERT INTO actors (actor_id, person_id) VALUES
(1, 1),
(2, 2);

-- Insert sample screenwriters
INSERT INTO screenwriters (screenwriter_id, person_id) VALUES
(3, 3);

-- Insert sample directors
INSERT INTO directors (director_id, person_id) VALUES
(3, 3);

-- Insert sample castings
INSERT INTO castings (movie_id, actor_id) VALUES
(1, 1),
(2, 2);

-- Insert sample saved lists
INSERT INTO saved_lists (movie_id, list_id) VALUES
(1, 1),
(2, 2);
