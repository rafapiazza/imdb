package com.example.interview.services;

import com.example.interview.models.dtos.MovieVoteDTO;
import com.example.interview.models.dtos.VoteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VoteService {
    List<VoteDTO> getVotes();

    VoteDTO getVoteById(Long id);

    Long createVote(MovieVoteDTO vote, String username);
}
