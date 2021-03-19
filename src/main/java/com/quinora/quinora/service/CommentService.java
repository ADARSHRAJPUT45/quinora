package com.quinora.quinora.service;

import com.quinora.quinora.dto.CommentRequestDTO;
import com.quinora.quinora.dto.CommentResponseDTO;
import com.quinora.quinora.entity.Comment;

public interface CommentService {
    CommentResponseDTO createComment(CommentRequestDTO commentRequestDTO);
}
