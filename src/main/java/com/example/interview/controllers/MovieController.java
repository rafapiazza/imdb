package com.example.interview.controllers;

import com.example.interview.models.dtos.MovieDTO;
import com.example.interview.models.dtos.MovieRequestDTO;
import com.example.interview.services.MovieService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityScheme(name = "bearerTest", scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
@SecurityRequirement(name = "bearerTest")
@RequestMapping("/movies")

@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    @GetMapping("/mostVoted")
    public List<MovieDTO> getMovies(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "5") int size) {
        return movieService.getMovies(page, size);
    }

    @GetMapping("/title/{title}")
    public MovieDTO getByNameMovie(@PathVariable String title) {
        return movieService.getByNameMovie(title);
    }

//    @GetMapping("/id/{id}")
//    public MovieDTO getByIdMovie(@PathVariable Long id) {
//        return movieService.getByIdMovie(id);
//    }

    @GetMapping("/director/{director}")
    public List<MovieDTO> getByDirectorMovie(@PathVariable String director,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "5") int size) {
        return movieService.getByDirectorMovie(director, page, size);
    }

    @GetMapping("/genre/{genre}")
    public List<MovieDTO> getByGenreMovie(@PathVariable String genre,
                                          @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "5") int size) {
        return movieService.getByGenreMovie(genre, page, size);
    }

    @GetMapping("/actor/{actor}")
    public List<MovieDTO> getByActorMovie(@PathVariable String actor,
                                          @RequestParam(required = false, defaultValue = "0") int page,
                                          @RequestParam(required = false, defaultValue = "5") int size) {
        return movieService.getByActorMovie(actor, page, size);
    }

    @PostMapping("/{username}")
    public List<Integer> createMovies(
            @RequestBody MovieRequestDTO movieDTO, @PathVariable String username) {
        return movieService.createMovie(movieDTO, username);
    }

}
