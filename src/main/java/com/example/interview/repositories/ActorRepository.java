package com.example.interview.repositories;

import com.example.interview.models.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    Actor findByName(String name);

    @Query("SELECT a FROM Actor a WHERE a.name = :name")
    Actor findByActorName(@Param("name") String name);
}
