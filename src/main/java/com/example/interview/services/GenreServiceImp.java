package com.example.interview.services;

import com.example.interview.models.dtos.GenreDTO;
import com.example.interview.models.entities.Genre;
import com.example.interview.repositories.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImp implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public List<GenreDTO> getGenres() {
        List<Genre> genres = genreRepository.findAll();

        return new ModelMapper().map(genres, new TypeToken<List<GenreDTO>>() {
        }.getType());
    }

    @Override
    public Long createGenre(GenreDTO genreDTO) {
        Genre genre = new ModelMapper().map(genreDTO, Genre.class);
        try {
            genre = genreRepository.save(genre);
        } catch (Exception e) {
            return null;
        }
        return genre.getId();
    }

    @Override
    public GenreDTO getByNameGenre(String name) {
        Genre genre = genreRepository.findByName(name);

        return new ModelMapper().map(genre, GenreDTO.class);
    }

    @Override
    public GenreDTO getByIdGenre(Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow(RuntimeException::new);
        return new ModelMapper().map(genre, GenreDTO.class);
    }
}
