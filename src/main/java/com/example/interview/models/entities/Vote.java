package com.example.interview.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "score", precision = 2, scale = 1)
    private BigDecimal score;

    @Column(name = "user", length = 45)
    private String user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

}
