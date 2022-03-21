package com.example.interview.services;

import com.example.interview.models.dtos.MovieDTO;
import com.example.interview.models.dtos.MovieRequestDTO;
import com.example.interview.models.entities.*;
import com.example.interview.repositories.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImp implements MovieService {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;
    private final UserRepository userRepository;

    @Override
    public List<MovieDTO> getMovies(int page, int size) {

        Pageable pageable = Pageable.ofSize(size).withPage(page);

        List<Movie> movies = movieRepository.findAllMoviesMostVoted(pageable);

        return new ModelMapper().map(movies, new TypeToken<List<MovieDTO>>() {
        }.getType());
    }

    @Override
    public List<Integer> createMovie(MovieRequestDTO movieDTO, String username) {

        User user = userRepository.findByUsername(username);
        if (user != null && !user.getIsAdmin()) {
            throw new UsernameNotFoundException("User " + username + " is not admin!");
        }
        if (user != null &&!user.getIsActive()) {
            throw new UsernameNotFoundException("User " + username + " is not active!");
        }

        List<Movie> movies = new ArrayList<>();

        Movie movie = new Movie(0, movieDTO.getTitle(), movieDTO.getGenres(), movieDTO.getDirector(), movieDTO.getActors(), null);
        movies.add(movie);


        List<Integer> idSuccessfulCreated = new ArrayList<>();

        try {
            movie = movieRepository.save(movie);
            idSuccessfulCreated.add(movie.getId());
        } catch (Exception e) {
            return null;
        }

        return idSuccessfulCreated;

    }

    @Override
    public MovieDTO getByNameMovie(String title) {
        Movie movie = movieRepository.findByTitle(title);

        List<Vote> votes = movie.getVotes();
        Double average = votes
                .stream()
                .mapToDouble(a -> a.getScore().doubleValue())
                .average().orElse(0.0);

        MovieDTO movieDTO = new ModelMapper().map(movie, MovieDTO.class);
        movieDTO.setAvgScore(average);

        return movieDTO;
    }

    @Override
    public MovieDTO getByIdMovie(Long id) {
        Movie movie = movieRepository.findMovieById(Math.toIntExact(id));

        return new ModelMapper().map(movie, MovieDTO.class);
    }

    @Override
    public List<MovieDTO> getByDirectorMovie(String director_name, int page, int size) {

        Long directorId = directorRepository.findByDirectorIdBtName(director_name);

        Pageable pageable = Pageable.ofSize(size).withPage(page);

        List<Movie> movies = movieRepository.findAllMoviesByDirector(directorId, pageable);

//        List<Movie> movies = Collections.emptyList();

        return new ModelMapper().map(movies, new TypeToken<List<MovieDTO>>() {
        }.getType());
    }

    @Override
    public List<MovieDTO> getByGenreMovie(String genre_name, int page, int size) {

        Genre genre = genreRepository.findByGenreName(genre_name);

        Pageable pageable = Pageable.ofSize(size).withPage(page);
        List<Movie> movies = movieRepository.findAllMoviesByGenre(genre.getId(), pageable);

        return new ModelMapper().map(movies, new TypeToken<List<MovieDTO>>() {
        }.getType());
    }

    @Override
    public List<MovieDTO> getByActorMovie(String actor_name, int page, int size) {

        Actor actor = actorRepository.findByActorName(actor_name);

        Pageable pageable = Pageable.ofSize(size).withPage(page);
        List<Movie> movies = movieRepository.findAllMoviesByActor(actor.getId(), pageable);

        return new ModelMapper().map(movies, new TypeToken<List<MovieDTO>>() {
        }.getType());
    }

}
