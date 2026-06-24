package com.example.week6;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheerMessageRepository extends JpaRepository<CheerMessage, Integer> {
//Pageable을 파라미터로 받으면 정렬과 페이징이 자동으로 적용된 Page 객체를 반환함
}
