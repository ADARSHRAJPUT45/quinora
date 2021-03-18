package com.quinora.quinora.service.impl;

import com.quinora.quinora.dto.AnswerRequestDTO;
import com.quinora.quinora.dto.AnswerResponseDTO;
import com.quinora.quinora.entity.Answer;
import com.quinora.quinora.repository.AnswerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import java.io.IOException;
import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
class AnswerServiceImplTest {

    @InjectMocks
    private AnswerServiceImpl answerService;

    @Mock
    private AnswerRepository answerRepository;

    @BeforeEach
    public void init () {
        MockitoAnnotations.openMocks(this);
    }


    @AfterEach
    public void teardown() {
    }

    @Test
    void getAnswers() throws IOException {

        Answer answer = new Answer();

        answer.setAnswerId(2L);
        answer.setAnswerText("HTML is known as hyper text markup language");

        Mockito.when(answerRepository.findById(1L)).thenReturn(Optional.of(answer));

        AnswerResponseDTO answerResponseDTO = answerService.getAnswerById(1L);
        assertEquals(answerResponseDTO.getAnswerId(), 2L);
    }

    @Test
    void createAnswers() throws IOException {

        Answer answer = new Answer();

        answer.setAnswerId(3L);
        answer.setAnswerText("Java is object oriented");

        Mockito.when(answerRepository.save(any(Answer.class))).thenReturn(answer);

        AnswerRequestDTO answerRequestDTO = new AnswerRequestDTO();

        AnswerResponseDTO answerResponseDTO = answerService.createAnswer(answerRequestDTO);
        assertEquals(answerResponseDTO.getAnswerId(), 3L);

    }

}
