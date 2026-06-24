package com.mysite.sbb.practice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class ClubMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String name;

    private String studentNumber;

    private String role;

    private LocalDateTime joinDate;

    @ManyToOne
    private Department department;
}