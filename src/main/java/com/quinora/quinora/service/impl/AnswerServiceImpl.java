package com.quinora.quinora.service.impl;

import com.quinora.quinora.dto.AnswerRequestDTO;
import com.quinora.quinora.dto.AnswerResponseDTO;
import com.quinora.quinora.entity.Answer;
import com.quinora.quinora.repository.AnswerRepository;
import com.quinora.quinora.service.AnswerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public AnswerResponseDTO createAnswer(AnswerRequestDTO answerRequestDTO) {

        Answer answer = new Answer();
        BeanUtils.copyProperties(answerRequestDTO, answer);

        Answer savedAnswer = answerRepository.save(answer);

        AnswerResponseDTO responseDto = new AnswerResponseDTO();
        BeanUtils.copyProperties(savedAnswer, responseDto);
        return responseDto;
    }

    @Override
    public AnswerResponseDTO getAnswerById(Long id) {
        Optional<Answer> answerOptional = answerRepository.findById(id);
        if (answerOptional.isPresent()) {
            //copy from answer to response dto
            AnswerResponseDTO responseDTO = new AnswerResponseDTO();
            BeanUtils.copyProperties(answerOptional.get(), responseDTO);
            return responseDTO;
        }
        return null;
    }

    @Override
    public AnswerResponseDTO updateAnswerById(Long id, AnswerRequestDTO answerRequestDTO) {
        Optional<Answer> answerOptional = answerRepository.findById(id);
        if (answerOptional.isPresent()) {

            Answer answerFromDb = answerOptional.get();

            answerFromDb.setAnswerId(answerRequestDTO.getAnswerId());
            answerFromDb.setAnswerText(answerRequestDTO.getAnswerText());

            Answer savedAnswer = answerRepository.save(answerFromDb);

            AnswerResponseDTO responseDTO = new AnswerResponseDTO();
            BeanUtils.copyProperties(savedAnswer, responseDTO);
            return responseDTO;
        }
        return null;
    }
}
