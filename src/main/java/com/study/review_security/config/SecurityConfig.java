package com.study.review_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.RequiredArgsConstructor;

@Configuration // 설정정보임을 명시
@EnableWebSecurity // 해당 시큐리티 필터 설정값들을 기본 필터 체인에 등록
@RequiredArgsConstructor
public class SecurityConfig {

    // 생성자 주입
    private final AuthenticationSuccessHandler loginSuccessHandler;
    private final AuthenticationFailureHandler loginFailureHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/loginSuccess").authenticated()
                .antMatchers("/user/**").hasAuthority("ROLE_USER")
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/login")
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler)
                .usernameParameter("id")
                .defaultSuccessUrl("/loginSuccess"); // [주의] defaultUrl을 지정해주면 로그인 성공시, 로그인 성공 핸들러를 타지 않음

        return http.build();
    }

}
