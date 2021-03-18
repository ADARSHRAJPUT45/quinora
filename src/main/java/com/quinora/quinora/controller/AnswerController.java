package com.quinora.quinora.controller;

import com.quinora.quinora.dto.AnswerRequestDTO;
import com.quinora.quinora.dto.AnswerResponseDTO;
import com.quinora.quinora.entity.Answer;
import com.quinora.quinora.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @PostMapping
    public AnswerResponseDTO createAnswer(@RequestBody AnswerRequestDTO answerRequestDTO){
        return answerService.createAnswer(answerRequestDTO);


    }
    @GetMapping("/{id}")
    public AnswerResponseDTO getAnswerById(@PathVariable("id")Long id){
    return answerService.getAnswerById(id);
        }
}
