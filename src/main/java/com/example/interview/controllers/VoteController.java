package com.example.interview.controllers;

import com.example.interview.models.dtos.MovieVoteDTO;
import com.example.interview.models.dtos.VoteDTO;
import com.example.interview.services.VoteService;
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
@RequestMapping("/votes")
@AllArgsConstructor
public class VoteController {

    private VoteService voteService;

//    @GetMapping("")
//    public List<VoteDTO> getVotes() {
//        return voteService.getVotes();
//    }

//    @GetMapping("/id/{id}")
//    public VoteDTO getVoteById(@PathVariable Long id) {
//        return voteService.getVoteById(id);
//    }

    @PostMapping("username/{username}")
    public Long createVote(
            @RequestBody MovieVoteDTO vote, @PathVariable String username) {
        return voteService.createVote(vote, username);
    }
}