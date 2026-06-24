package com.mysite.sbb.question;


import com.mysite.sbb.answer.AnswerForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/question")
@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")

    /*
    타임리프(Thymeleaf)나 JSP 같은 템플릿 엔진을 사용한다면
    데이터를 뷰로 넘겨야 하므로 Model, ModelAndView, Map 중 하나는 반드시 사용해야 합니다. 이 중 Model 방식이 가장 직관적이고 Spring에서 권장하는 표준 방식입니다.
    REST API를 구축한다면 (React, Vue 등 프론트엔드 분리)
    Model 자체가 필요 없습니다. @RestController를 사용하고 데이터를 직접 반환하면 JSON 형태로 출력됩니다.
     */
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
/*
* 데이터가 비어 있을 가능성이 있거나 자료구조(Collection)를 활용해야 한다면 Integer를,
* 그 외의 순수 계산용도라면 int를 사용하는 것이 기본 원칙*/
    @GetMapping(value="/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model, AnswerForm answerForm) {
        Question question=this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
    
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    //@Vaild를 적용하면 QuestionForm에서의 검증 기능이 동작. BindingResult는 이걸로 검증이 된 결과를 의미하는 객체
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "question_form"; //입력 데이터에 오류가 있으면 다시 입력창으로 돌아감
        }

        this.questionService.create(questionForm.getSubject(),questionForm.getContent()); //질문 저장
        return "redirect:/question/list"; //질문 저장 후 질문 목록으로 이동
    }
}
