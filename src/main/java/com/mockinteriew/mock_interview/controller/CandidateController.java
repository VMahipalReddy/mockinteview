package com.mockinteriew.mock_interview.controller;

import com.mockinteriew.mock_interview.dto.CandidateDTO;
import com.mockinteriew.mock_interview.model.User;
import com.mockinteriew.mock_interview.service.CandidateService;
import com.mockinteriew.mock_interview.util.CandidateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping
    public List<CandidateDTO> getAllCandidates() {
        return candidateService.getAllCandidates().stream()
                .map(CandidateMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{email}")
    public ResponseEntity<CandidateDTO> getCandidateByEmail(@PathVariable String email) {
        User candidate = candidateService.getCandidateByEmail(email);
        if (candidate != null) {
            return ResponseEntity.ok(CandidateMapper.toDTO(candidate));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public CandidateDTO createCandidate(@RequestBody CandidateDTO candidateDTO) {
        User candidate = CandidateMapper.toEntity(candidateDTO);
        User createdCandidate = candidateService.createCandidate(candidate);
        return CandidateMapper.toDTO(createdCandidate);
    }

    @PutMapping("/{email}")
    public ResponseEntity<CandidateDTO> updateCandidate(@PathVariable String email, @RequestBody CandidateDTO candidateDTO) {
        User candidateDetails = CandidateMapper.toEntity(candidateDTO);
        User updatedCandidate = candidateService.updateCandidate(email, candidateDetails);
        if (updatedCandidate != null) {
            return ResponseEntity.ok(CandidateMapper.toDTO(updatedCandidate));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable String email) {
        boolean isDeleted = candidateService.deleteCandidate(email);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}