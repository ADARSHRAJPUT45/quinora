package com.quinora.quinora.service.impl;

import com.quinora.quinora.dto.CommentRequestDTO;
import com.quinora.quinora.dto.CommentResponseDTO;
import com.quinora.quinora.entity.Comment;
import com.quinora.quinora.repository.CommentRepository;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
 class CommentServiceTestImpl {
    @InjectMocks
    private CommentServiceImpl commentService;

    @Mock
    private CommentRepository commentRepository;

    @BeforeEach
    public void init () {
        MockitoAnnotations.openMocks(this);
    }


    @AfterEach
    public void teardown() {
    }
    @Test
    void createComment() throws IOException {

        Comment comment = new Comment();

        comment.setCommentId(3L);
        comment.setCommentText("What is Java");

        Mockito.when(commentRepository.save(any(Comment.class))).thenReturn(comment);

        CommentRequestDTO commentRequestDTO = new CommentRequestDTO();

        CommentResponseDTO commentResponseDTO = commentService.createComment(commentRequestDTO);
        assertEquals(commentResponseDTO.getCommentId(), 3L);

    }

}
