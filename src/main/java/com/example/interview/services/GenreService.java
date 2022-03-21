package com.example.interview.services;

import com.example.interview.models.dtos.GenreDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenreService {
    List<GenreDTO> getGenres();

    Long createGenre(GenreDTO genreDTO);

    GenreDTO getByNameGenre(String name);

    GenreDTO getByIdGenre(Long id);
}