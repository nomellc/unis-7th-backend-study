package com.mysite.sbb.practice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CheerMessageService {

    private final CheerMessageRepository cheerMessageRepository;

    public void create(String writer, String content) {
        CheerMessage cheerMessage = new CheerMessage();
        cheerMessage.setWriter(writer);
        cheerMessage.setContent(content);
        cheerMessage.setCreateDate(LocalDateTime.now());

        this.cheerMessageRepository.save(cheerMessage);
    }

    public Page<CheerMessage> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));

        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));

        return this.cheerMessageRepository.findAll(pageable);
    }
}