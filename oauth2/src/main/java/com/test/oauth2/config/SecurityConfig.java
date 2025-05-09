package com.test.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //암호 인코더 > 필요 (X)
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //CRSF > 비활성화
        http.csrf(auth -> auth.disable());

        //Form 로그인 X
        http.formLogin(auth -> auth.disable());

        //기본인증 > 사용안함
        http.httpBasic(auth -> auth.disable());

        //허가 URI
        http.authorizeRequests(auth -> auth
                .requestMatchers("/").permitAll()
                .anyRequest().authenticated()
        );

        return http.build();
    };
}
