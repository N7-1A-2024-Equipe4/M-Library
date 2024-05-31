SELECT movie.title,
MAX(CASE WHEN actor_in_movie.actor_rank = 1 THEN person.first_name END) AS 'Actor 1',
MAX(CASE WHEN actor_in_movie.actor_rank = 2 THEN person.first_name END) AS 'Actor 2',
MAX(CASE WHEN actor_in_movie.actor_rank = 3 THEN person.first_name END) AS 'Actor 3'
FROM movie
JOIN actor_in_movie ON movie.movie_id = actor_in_movie.movie_id
JOIN person ON actor_in_movie.person_id = person.person_id
GROUP BY movie.title;

/*SELECT movie.title, GROUP_CONCAT(person.first_name) AS actors
FROM movie
JOIN actor_in_movie ON movie.movie_id = actor_in_movie.movie_id
JOIN person ON actor_in_movie.person_id = person.person_id
GROUP BY movie.title;*/

/*
WHERE  IN (SELECT person.person_id
FROM person
JOIN actor_in_movie ON person.person_id = actor_in_movie.person_id
WHERE actor_in_movie.movie_id = 1);*/

/*
SELECT *
FROM movie
JOIN actor_in_movie ON movie.movie_id = actor_in_movie.movie_id
JOIN person ON actor_in_movie.person_id = person.person_id
WHERE person
*/