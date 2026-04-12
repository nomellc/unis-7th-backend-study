package com.example.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@GetMapping("/profile")
	@ResponseBody
	public String profile() {
		return "이름은 김시윤입니다. 취미는 야구보기입니다.";
	}
}