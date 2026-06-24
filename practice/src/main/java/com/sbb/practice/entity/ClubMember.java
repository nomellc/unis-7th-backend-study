package com.sbb.practice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubMember {

    //부원 고유 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //부원 이름
    @Column(length=30)
    private String name;

    //학번
    private Long studentNumber;

    //동아리 내 역할
    private String role;

    //가입 일시
    private LocalDateTime joinDate;

    //부원이 속한 부서(외래키)
    @ManyToOne
    private Department department;

}
