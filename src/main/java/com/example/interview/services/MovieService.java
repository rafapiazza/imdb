package com.example.interview.services;

import com.example.interview.models.dtos.MovieDTO;
import com.example.interview.models.dtos.MovieRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    List<MovieDTO> getMovies(int page, int size);

    List<Integer> createMovie(MovieRequestDTO movieDTO, String username);

    MovieDTO getByNameMovie(String tittle);

    MovieDTO getByIdMovie(Long id);

    List<MovieDTO> getByDirectorMovie(String director, int page, int size);

    List<MovieDTO> getByGenreMovie(String genre_name, int page, int size);

    List<MovieDTO> getByActorMovie(String actor_name, int page, int size);
}
