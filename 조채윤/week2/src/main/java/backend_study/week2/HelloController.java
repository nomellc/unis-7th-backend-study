package backend_study.week2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/profile")
    public String profile() {
        return "이름은 김이화입니다. 취미는 독서입니다. ";
    }
}
