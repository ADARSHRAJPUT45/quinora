package com.quinora.quinora.controller;

import com.quinora.quinora.dto.QuestionRequestDTO;
import com.quinora.quinora.dto.QuestionResponseDTO;
import com.quinora.quinora.entity.Question;
import com.quinora.quinora.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping
    public QuestionResponseDTO createQuestion(@RequestBody QuestionRequestDTO questionRequestDTO){
        return questionService.createQuestion(questionRequestDTO);
    }

    //get
    @GetMapping("/{id}")
    public QuestionResponseDTO getQuestionById(@PathVariable("id") Long id){
        return questionService.getQuestionById(id);
    }
    @PutMapping("/{id}")
    public QuestionResponseDTO updateQuestion(@PathVariable("id") Long id,@RequestBody QuestionRequestDTO questionRequestDTO){
        return questionService.updateQuestionById(id,questionRequestDTO);
    }
    @DeleteMapping("/{id}")
    public QuestionResponseDTO deleteQuestion(@PathVariable("id") Long id){
        return questionService.deleteQuestion(id);
    }

}
