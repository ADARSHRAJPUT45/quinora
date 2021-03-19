package com.quinora.quinora.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GenericGenerator(name = "comment_id",strategy = "increment")
    @GeneratedValue(generator = "comment_id",strategy = GenerationType.AUTO)
    private Long commentId;
    private String commentText;

}
