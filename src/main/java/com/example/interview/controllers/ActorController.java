package com.example.interview.controllers;

import com.example.interview.models.dtos.ActorDTO;
import com.example.interview.services.ActorService;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityScheme(name = "bearerTest", scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
@SecurityRequirement(name = "bearerTest")
@RequestMapping("/actors")
@AllArgsConstructor
public class ActorController {

    private ActorService actorService;

//    @GetMapping("")
//    public List<ActorDTO> getActors() {
//        return actorService.getActors();
//    }
//
//    @GetMapping("/name/{name}")
//    public ActorDTO getByNameActor(@PathVariable String name) {
//        return actorService.getByNameActor(name);
//    }
//
//    @GetMapping("/id/{id}")
//    public ActorDTO getByIdActor(@PathVariable Long id) {
//        return actorService.getByIdActor(id);
//    }
//
//    @PostMapping("")
//    public Long createActor(
//            @RequestBody ActorDTO actorDTO) {
//        return actorService.createActor(actorDTO);
//    }
}