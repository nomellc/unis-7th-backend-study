package com.example.week6;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class CheerMessage {
    //응원메시지 고유 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //작성자 이름
    private String writer;

    //응원 메시지 내용
    @Column(columnDefinition = "TEXT")
    private String content;

    //작성 일시
    private LocalDateTime createDate;

    //service 계층에서 정보 넘겨받아 객체 생성
    public CheerMessage(String writer, String content) {
        this.writer = writer;
        this.content = content;
        this.createDate = LocalDateTime.now();
    }

}
