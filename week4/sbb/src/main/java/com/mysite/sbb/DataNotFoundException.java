package com.mysite.sbb;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

//예외 발생 시 설저된 HTTP 상태 코드(404)와 이유를 포함한 응답을 생성해 클라이언트에게 반환
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason="entity not found")
public class DataNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public DataNotFoundException(String message) {
        super(message);
    }
}
