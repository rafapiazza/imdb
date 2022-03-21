package com.example.interview.controllers;

import com.example.interview.models.dtos.GenreDTO;
import com.example.interview.services.GenreService;
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
@RequestMapping("/genres")
@AllArgsConstructor
public class GenreController {

//    private GenreService genreService;
//
//    @GetMapping("")
//    public List<GenreDTO> getGenres() {
//        return genreService.getGenres();
//    }
//
//    @GetMapping("/name/{name}")
//    public GenreDTO getByNameGenre(@PathVariable String name) {
//        return genreService.getByNameGenre(name);
//    }
//
//    @GetMapping("/id/{id}")
//    public GenreDTO getByIdGenre(@PathVariable Long id) {
//        return genreService.getByIdGenre(id);
//    }
//
//    @PostMapping("")
//    public Long createGenre(
//            @RequestBody GenreDTO genreDTO) {
//        return genreService.createGenre(genreDTO);
//    }
}
