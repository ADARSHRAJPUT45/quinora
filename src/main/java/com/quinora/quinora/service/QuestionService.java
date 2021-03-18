package com.quinora.quinora.service;

import com.quinora.quinora.dto.QuestionRequestDTO;
import com.quinora.quinora.dto.QuestionResponseDTO;

public interface QuestionService  {
    QuestionResponseDTO createQuestion(QuestionRequestDTO questionRequestDTO);

    QuestionResponseDTO getQuestionById(Long id);

    QuestionResponseDTO updateQuestionById(Long id, QuestionRequestDTO questionRequestDTO);


    QuestionResponseDTO deleteQuestion(Long id);
}
