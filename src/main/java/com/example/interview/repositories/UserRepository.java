package com.example.interview.repositories;

import com.example.interview.models.entities.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

//    List<User> findAllUsersByIsAdmin(Pageable pageable);

    @Query(value = "select " +
            "u.* " +
            "from " +
            "`user` u " +
            "where u.is_admin =0 and u.is_active =1 order by u.username asc ", countQuery = "select u.* from user u", nativeQuery = true)
    List<User> findAllNormalUser(Pageable pageable);

    @Query(value = "SELECT u FROM User u WHERE u.isAdmin = 0 ORDER BY u.username")
    List<User> findByOrderByUsernameASC();

    @Transactional
    @Modifying
    @Query("UPDATE FROM User u SET isActive=0 WHERE u.username = :username AND u.isActive = 1")
    void updateUserActive(@Param("username") String username);

}
