package com.example.interview.services;

import com.example.interview.models.dtos.MovieVoteDTO;
import com.example.interview.models.dtos.VoteDTO;
import com.example.interview.models.entities.Movie;
import com.example.interview.models.entities.User;
import com.example.interview.models.entities.Vote;
import com.example.interview.repositories.MovieRepository;
import com.example.interview.repositories.UserRepository;
import com.example.interview.repositories.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoteServiceImp implements VoteService {

    private final VoteRepository voteRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;


    @Override
    public List<VoteDTO> getVotes() {
        List<Vote> votes = voteRepository.findAll();

        return new ModelMapper().map(votes, new TypeToken<List<VoteDTO>>() {
        }.getType());
    }

    @Override
    public VoteDTO getVoteById(Long id) {
        Vote vote = voteRepository.findById(id).orElseThrow(RuntimeException::new);

        return new ModelMapper().map(vote, VoteDTO.class);
    }

    @Override
    public Long createVote(MovieVoteDTO voteMap, String username) {

        User user = userRepository.findByUsername(username);
        if (user != null && user.getIsAdmin()) {
            throw new UsernameNotFoundException("User " + username + " is admin!");
        }
        if (user != null &&!user.getIsActive()) {
            throw new UsernameNotFoundException("User " + username + " is not active!");
        }

        Vote vote = new ModelMapper().map(voteMap, Vote.class);
        Movie movie = movieRepository.findMovieById(voteMap.getMovieId());
        vote.setMovie(movie);
        voteRepository.save(vote);

        return vote.getId();
    }
}
