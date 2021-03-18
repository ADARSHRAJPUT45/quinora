package com.quinora.quinora.service.impl;

import com.quinora.quinora.dto.QuestionRequestDTO;
import com.quinora.quinora.dto.QuestionResponseDTO;
import com.quinora.quinora.entity.Question;
import com.quinora.quinora.repository.QuestionRepository;
import com.quinora.quinora.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public QuestionResponseDTO createQuestion(QuestionRequestDTO questionRequestDTO) {
        Question question = new Question();

        //copy fields from dto to question
        BeanUtils.copyProperties(questionRequestDTO, question);

        //save question to db
        Question savedQuestion = questionRepository.save(question);

        // copy from question to response dto
        QuestionResponseDTO responseDto = new QuestionResponseDTO();

        BeanUtils.copyProperties(savedQuestion, responseDto);

        return responseDto;
    }

    @Override
    public QuestionResponseDTO getQuestionById(Long id) {
        Optional<Question> questionOptional = questionRepository.findById(id);
        if (questionOptional.isPresent()) {
            //copy from question to response dto
            QuestionResponseDTO responseDTO = new QuestionResponseDTO();
            BeanUtils.copyProperties(questionOptional.get(), responseDTO);
            return responseDTO;
        }
        return null;
    }
    @Override
    public QuestionResponseDTO updateQuestionById(Long id, QuestionRequestDTO questionRequestDTO) {
        Optional<Question> questionOptional = questionRepository.findById(id);
        if (questionOptional.isPresent()) {
            //copy from employee to response dto
            Question questionFromDb = questionOptional.get();

            questionFromDb.setQuestionId(questionRequestDTO.getQuestionId());
            questionFromDb.setQuestionText(questionRequestDTO.getQuestionText());
            //save to db
            Question savedQuestion = questionRepository.save(questionFromDb);

            //copy from question to responseDTO
            QuestionResponseDTO responseDTO = new QuestionResponseDTO();
            BeanUtils.copyProperties(savedQuestion, responseDTO);
            return responseDTO;
        }
        return null;
    }

    @Override
    public QuestionResponseDTO deleteQuestion(Long id){
        Optional<Question> questionOptional = questionRepository.findById(id);
        if (questionOptional.isPresent())
        {
            Question questionFromDb = questionOptional.get();
            questionRepository.delete(questionFromDb);

            QuestionResponseDTO responseDTO = new QuestionResponseDTO();
            BeanUtils.copyProperties(questionOptional,responseDTO);
            return responseDTO;
        }

        return null;
    }

}
