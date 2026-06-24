package com.mysite.sbb.practice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class CheerMessageController {

    private final CheerMessageService cheerMessageService;

    @PostMapping("/cheer/create")
    public String createCheerMessage(@RequestParam(value = "writer") String writer,
                                     @RequestParam(value = "content") String content) {

        this.cheerMessageService.create(writer, content);

        return "redirect:/";
    }
}