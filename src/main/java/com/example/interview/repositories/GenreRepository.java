package com.example.interview.repositories;

import com.example.interview.models.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    Genre findByName(String name);

    @Query("SELECT g FROM Genre g WHERE g.name = :name")
    Genre findByGenreName(@Param("name") String name);
}
