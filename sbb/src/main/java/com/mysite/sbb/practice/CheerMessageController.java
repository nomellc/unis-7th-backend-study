package com.mysite.sbb.practice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class CheerMessageController {

    private final CheerMessageService cheerMessageService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/cheer/create")
    public String createCheerMessage(@RequestParam(value = "writer") String writer,
                                     @RequestParam(value = "content") String content) {

        this.cheerMessageService.create(writer, content);

        return "redirect:/cheer/list";
    }

    @GetMapping("/cheer/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<CheerMessage> paging = this.cheerMessageService.getList(page);
        model.addAttribute("paging", paging);
        return "cheer_list"; // 응원 메시지 목록을 보여줄 HTML 템플릿 이름
    }
}