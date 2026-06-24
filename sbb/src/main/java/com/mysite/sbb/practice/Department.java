package com.mysite.sbb.practice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    private List<ClubMember> memberList;
}