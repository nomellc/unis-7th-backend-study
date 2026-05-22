package com.nakyung.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping("/profile")
    @ResponseBody
    public String profile() {
        return "이름은 하나경입니다. 취미는 독서입니다.";
    }
}
