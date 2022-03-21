package com.example.interview.controllers;

import com.example.interview.models.dtos.DirectorDTO;
import com.example.interview.services.DirectorService;
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
@RequestMapping("/directors")
@AllArgsConstructor
public class DirectorController {

//    private DirectorService directorService;
//
//    @GetMapping("")
//    public List<DirectorDTO> getDirectors() {
//        return directorService.getDirectors();
//    }
//
//    @GetMapping("/name/{name}")
//    public DirectorDTO getByNameDirector(@PathVariable String name) {
//        return directorService.getByNameDirector(name);
//    }
//
//    @GetMapping("/id/{id}")
//    public DirectorDTO getByIdDirector(@PathVariable Long id) {
//        return directorService.getByIdDirector(id);
//    }
//
//    @PostMapping("")
//    public Long createDirector(
//            @RequestBody DirectorDTO directorDTO) {
//        return directorService.createDirector(directorDTO);
//    }
}