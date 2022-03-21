package com.example.interview.repositories;

import com.example.interview.models.dtos.MovieDTO;
import com.example.interview.models.entities.Director;
import com.example.interview.models.entities.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByTitle(@Param("title") String title);

    @Query("SELECT m FROM Movie m WHERE m.id = :movie_id")
    Movie findMovieById(@Param("movie_id") Integer movieId);

    @Query(value = "select m.* " +
            "from " +
            "movie m " +
            "where m.director_id = :id", countQuery = "select m.* from movie m", nativeQuery = true)
    List<Movie> findAllMoviesByDirector(Long id, Pageable pageable);

    @Query(value = "select m.* , g.* " +
            "from " +
            "movie m " +
            "left outer join genre_movie mg ON(m.id = mg.movie_id) " +
            "left outer join genre g ON(g.id = mg.genre_id) " +
            "where g.id = :id", countQuery = "select m.* from movie m", nativeQuery = true)
    List<Movie> findAllMoviesByGenre(@Param("id") Long id, Pageable pageable);

    @Query(value = "select m.* , a.* " +
            "from " +
            "movie m " +
            "left outer join actor_movie am ON(m.id = am.movie_id) " +
            "left outer join actor a ON(a.id = am.actor_id) " +
            "where a.id = :id", countQuery = "select m.* from movie m", nativeQuery = true)
    List<Movie> findAllMoviesByActor(@Param("id") Long id, Pageable pageable);


    @Query(value = "select " +
            "m.*, " +
            "count(1) as numero_de_votos " +
            "from " +
            "movie m " +
            "left outer join vote v " +
            "ON (v.movie_id = m.id) " +
            "group by m.title " +
            "order by numero_de_votos desc, m.title ASC ", countQuery = "select m.* from movie m", nativeQuery = true)
    List<Movie> findAllMoviesMostVoted(Pageable pageable);
}
