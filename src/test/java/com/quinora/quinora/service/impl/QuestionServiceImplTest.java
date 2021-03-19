package com.quinora.quinora.service.impl;

import com.quinora.quinora.dto.AnswerRequestDTO;
import com.quinora.quinora.dto.AnswerResponseDTO;
import com.quinora.quinora.dto.QuestionRequestDTO;
import com.quinora.quinora.dto.QuestionResponseDTO;
import com.quinora.quinora.entity.Answer;
import com.quinora.quinora.entity.Question;
import com.quinora.quinora.repository.QuestionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
class QuestionServiceImplTest {
    @InjectMocks
    private QuestionServiceImpl questionService;

    @Mock
    private QuestionRepository questionRepository;

    @BeforeEach
    public void init () {
        MockitoAnnotations.openMocks(this);
    }


    @AfterEach
    public void teardown() {
    }

    @Test
    void getQuestions() throws IOException {

        Question question = new Question();

        question.setQuestionId(2L);
        question.setQuestionText("What is HTML");

        Mockito.when(questionRepository.findById(1L)).thenReturn(Optional.of(question));

        QuestionResponseDTO questionResponseDTO = questionService.getQuestionById(1L);
        assertEquals(questionResponseDTO.getQuestionId(), 2L);
    }
    @Test
    void createQuestions() throws IOException {

        Question question = new Question();

        question.setQuestionId(3L);
        question.setQuestionText("What is Java");

        Mockito.when(questionRepository.save(any(Question.class))).thenReturn(question);

        QuestionRequestDTO questionRequestDTO = new QuestionRequestDTO();

        QuestionResponseDTO questionResponseDTO = questionService.createQuestion(questionRequestDTO);
        assertEquals(questionResponseDTO.getQuestionId(), 3L,questionResponseDTO.getQuestionText());

    }
}
