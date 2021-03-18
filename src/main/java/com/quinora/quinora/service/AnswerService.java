package com.quinora.quinora.service;

import com.quinora.quinora.dto.AnswerRequestDTO;
import com.quinora.quinora.dto.AnswerResponseDTO;

public interface AnswerService {
    AnswerResponseDTO createAnswer(AnswerRequestDTO answerRequestDTO);

    AnswerResponseDTO getAnswerById(Long id);

    AnswerResponseDTO updateAnswerById(Long id, AnswerRequestDTO answerRequestDTO);
}
