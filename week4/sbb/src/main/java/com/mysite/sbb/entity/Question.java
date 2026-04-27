package com.mysite.sbb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length=200)
    private String subject;

    @Column(columnDefinition = "Text")
    private String content;

    private LocalDateTime createDate;

    //answer에서 question을 참조하려면 question.getAnswerList() 호출하면 됨
    //question 삭제하면 answer도 삭제
    //데이터베이스 상에서 answer 테이블이 question_id (기본 전략 시)라는 이름의 외래 키 컬럼을 가짐
    @OneToMany(mappedBy = "question",cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}
