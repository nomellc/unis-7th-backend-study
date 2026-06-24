package com.example.week6.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // REST API이므로 보통 disable
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/cheer/list").permitAll()      // 목록 조회는 누구나 가능
                        .requestMatchers("/cheer/create").authenticated() // 생성은 인증된 사용자만
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login.disable()) // REST API는 폼 로그인 대신 JWT 등을 주로 사용
                .httpBasic(basic -> basic.disable());

        return http.build();
    }
}

/*
핵심 구성 요소 이해 
SecurityFilterChain (필터 체인):
어떤 요청이 들어올 때 이 보안 필터를 태울 것인가를 결정하는 핵심 빈(Bean).

requestMatchers(...).permitAll() / authenticated():
이것이 실무에서 가장 많이 수정하는 부분입니다.
특정 URL 경로에 대해 '누구나 접근 가능(permitAll)'하게 할지,
'로그인한 사람만(authenticated)' 접근하게 할지 결정하는 스위치 역할을 합니다.

csrf().disable(): REST API 환경(Postman이나 프론트엔드와 통신)에서는 세션 방식이 아닌 토큰(JWT) 방식을 주로 쓰기 때문에, 기본적으로 켜져 있는 CSRF 방어 기능을 끄는 경우가 많습니다. (끄지 않으면 POST/PUT 요청 시 403 에러가 발생합니다.)
 */
