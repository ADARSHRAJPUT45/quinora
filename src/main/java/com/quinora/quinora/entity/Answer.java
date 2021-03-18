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
public class Answer {
    @Id
    @GenericGenerator(name = "question_id_seq", strategy = "increment")
    @GeneratedValue(generator = "question_id_seq", strategy = GenerationType.AUTO)
    private Long answerId;
    private String answerText;
}
