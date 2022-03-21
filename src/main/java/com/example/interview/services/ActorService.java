package com.example.interview.services;

import com.example.interview.models.dtos.ActorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActorService {
    List<ActorDTO> getActors();

    Long createActor(ActorDTO actorDTO);

    ActorDTO getByNameActor(String name);

    ActorDTO getByIdActor(Long id);
}