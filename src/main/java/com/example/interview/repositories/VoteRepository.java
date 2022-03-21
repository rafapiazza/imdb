package com.example.interview.repositories;

import com.example.interview.models.entities.Director;
import com.example.interview.models.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

//    @Query("SELECT COUNT(v) FROM Vote v WHERE v.movie.id = :movie_id")
//    Long findNumberVotes(@Param("movie_id") Integer movie_id);
//
//    @Query("SELECT AVG(v.score) FROM Vote v WHERE v.movie.id = :movie_id")
//    Long findAverageScores(@Param("movie_id") Integer movie_id);
}
