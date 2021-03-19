package com.quinora.quinora.controller;

import com.quinora.quinora.dto.CommentRequestDTO;
import com.quinora.quinora.dto.CommentResponseDTO;
import com.quinora.quinora.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping
    public CommentResponseDTO createComment(@RequestBody CommentRequestDTO commentRequestDTO){
        return commentService.createComment(commentRequestDTO);
    }
}
