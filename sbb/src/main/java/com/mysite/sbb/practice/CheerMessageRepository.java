package com.mysite.sbb.practice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CheerMessageRepository extends JpaRepository<CheerMessage, Integer> {
}
