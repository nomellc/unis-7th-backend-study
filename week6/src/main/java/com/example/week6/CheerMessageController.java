package com.example.week6;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor //의존성 주입 위해 필요
public class CheerMessageController {

    private final CheerMessageService cheerMessageService;

    //프엔에서 응원메시지 데이터 받음
    //@RequestBody:HTTP 요청의 본문에 담긴 데이터(JSON 형식)를 자바 객체로 변환하여 매개변수에 바인딩해줌
    @PostMapping("/cheer/create")
    public ResponseEntity<Void> create(@RequestBody CheerMessageDTO cheerMessageDTO) {
        cheerMessageService.create(cheerMessageDTO); //DTO 자체를 넘김
        return ResponseEntity.ok().build();
    }

    @GetMapping("/cheer/list")
    public ResponseEntity<Page<CheerMessageDTO>> getList(@RequestParam(defaultValue = "0") int page) {
        Page<CheerMessageDTO> paging = cheerMessageService.getList(page); //페이징 정보를 담은 DTO 객체를 가져옴

        return ResponseEntity.ok(paging);
    }
}

