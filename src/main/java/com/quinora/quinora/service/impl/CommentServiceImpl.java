package com.quinora.quinora.service.impl;


import com.quinora.quinora.dto.CommentRequestDTO;
import com.quinora.quinora.dto.CommentResponseDTO;
import com.quinora.quinora.entity.Comment;
import com.quinora.quinora.repository.CommentRepository;
import com.quinora.quinora.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public CommentResponseDTO createComment(CommentRequestDTO commentRequestDTO)
    {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentRequestDTO ,comment);

        Comment savedComment= commentRepository.save(comment);

        CommentResponseDTO responseDTO = new CommentResponseDTO();
        BeanUtils.copyProperties(savedComment,responseDTO);
        return responseDTO;
    }

}
