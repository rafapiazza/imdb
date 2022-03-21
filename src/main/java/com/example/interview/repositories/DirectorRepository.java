package com.example.interview.repositories;

import com.example.interview.models.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

    Director findByName(String name);

    @Query("SELECT d FROM Director d WHERE d.name = :name")
    Director findByDirectorName(@Param("name") String name);

    @Query("SELECT d.id FROM Director d WHERE d.name = :name")
    Long findByDirectorIdBtName(@Param("name") String name);
}
