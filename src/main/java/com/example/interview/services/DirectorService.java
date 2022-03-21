package com.example.interview.services;

import com.example.interview.models.dtos.DirectorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DirectorService {
    List<DirectorDTO> getDirectors();

    Long createDirector(DirectorDTO directorDTO);

    DirectorDTO getByNameDirector(String name);

    DirectorDTO getByIdDirector(Long id);
}