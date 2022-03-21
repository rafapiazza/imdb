package com.example.interview.models.dtos;

import com.example.interview.models.entities.Actor;
import com.example.interview.models.entities.Director;
import com.example.interview.models.entities.Genre;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieRequestDTO {

    private String title;

    private List<Genre> genres;

    private Director director;

    private List<Actor> actors;

}
