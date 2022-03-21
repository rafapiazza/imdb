package com.example.interview.services;

import com.example.interview.models.dtos.ActorDTO;
import com.example.interview.models.entities.Actor;
import com.example.interview.repositories.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceImp implements ActorService {

    private final ActorRepository actorRepository;

    @Override
    public List<ActorDTO> getActors() {
//        return Collections.singletonList(new MovieDTO(1L,"Interstellar"));
        List<Actor> actors = actorRepository.findAll();

        return new ModelMapper().map(actors, new TypeToken<List<ActorDTO>>() {
        }.getType());
    }

    @Override
    public Long createActor(ActorDTO actorDTO) {
        Actor actor = new ModelMapper().map(actorDTO, Actor.class);
        try {
            actor = actorRepository.save(actor);
        } catch (Exception e) {
            return null;
        }
        return actor.getId();
    }

    @Override
    public ActorDTO getByNameActor(String name) {
        Actor actor = actorRepository.findByName(name);

        return new ModelMapper().map(actor, ActorDTO.class);
    }

    @Override
    public ActorDTO getByIdActor(Long id) {
        Actor actor = actorRepository.findById(id).orElseThrow(RuntimeException::new);

        return new ModelMapper().map(actor, ActorDTO.class);
    }

}
