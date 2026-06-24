package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionForm;
import com.mysite.sbb.question.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    //question_detail.html에서 입력한 content를 매개변수로 받음
    //Model 객체:서버 내부 데이터를 화면(view)로 넘겨주기 위한 바구니->REST API에선 이것 대신 DTO 객체를 JSON으로 말아서 보냄
    //BindingResult:사용자가 보낸 데이터가 비즈니스 규칙에 어긋날 때,에러 내용 담아두는 객체
    //@PathVariable:URL 경로에서 변수를 추출하는 법
    //@RequestParam:쿼리 스트링에서 값을 받는법
    public String createAnswer(@PathVariable("id") Integer id, Model model, @Valid AnswerForm answerForm, BindingResult bindingResult){
        Question question=this.questionService.getQuestion(id);
        if(bindingResult.hasErrors()){
            model.addAttribute("question", question);
            return "question_detail"; //입력 데이터에 오류가 있으면 다시 입력창으로 돌아감
        }

        this.answerService.create(question,answerForm.getContent());
        return String.format("redirect:/question/detail/%s", id);

    }
}
