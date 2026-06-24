package com.mysite.sbb.practice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
}