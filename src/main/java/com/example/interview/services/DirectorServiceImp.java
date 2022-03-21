package com.example.interview.services;

import com.example.interview.models.dtos.DirectorDTO;
import com.example.interview.models.entities.Director;
import com.example.interview.repositories.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorServiceImp implements DirectorService {

    private final DirectorRepository directorRepository;

    @Override
    public List<DirectorDTO> getDirectors() {
        List<Director> directors = directorRepository.findAll();

//        return Collections.singletonList(new ModelMapper().map(directors.get(0), DirectorDTO.class));

        return new ModelMapper().map(directors, new TypeToken<List<DirectorDTO>>() {
        }.getType());
    }

    @Override
    public Long createDirector(DirectorDTO directorDTO) {
        Director director = new ModelMapper().map(directorDTO, Director.class);
        try {
            director = directorRepository.save(director);
        } catch (Exception e) {
            return null;
        }
        return director.getId();
    }

    @Override
    public DirectorDTO getByNameDirector(String name) {
        Director director = directorRepository.findByDirectorName(name);

        return new ModelMapper().map(director, DirectorDTO.class);
    }

    @Override
    public DirectorDTO getByIdDirector(Long id) {
        Director director = directorRepository.findById(id).orElseThrow(RuntimeException::new);

        return new ModelMapper().map(director, DirectorDTO.class);
    }
}
