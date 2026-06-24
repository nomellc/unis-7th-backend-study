package com.sbb.practice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Department {
    //부서 고유 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //부서 이름
    @Column(length = 50)
    private String name;

    //부서 설명
    @Column(columnDefinition = "TEXT")
    private String description;

    //부서 생성 일시
    private LocalDateTime createDate;

    //해당 부서에 속한 부원 목록
    @OneToMany(mappedBy = "department",cascade=CascadeType.REMOVE)
    List<ClubMember> memberList;
}
