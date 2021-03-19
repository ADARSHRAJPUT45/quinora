package com.quinora.quinora.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentRequestDTO {
    private Long commentId;
    private String commentText;
}
