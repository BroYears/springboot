package com.test.oauth2.config;

import com.test.oauth2.service.CustomOAuth2UserService;
import com.test.oauth2.service.OAuth2SuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final CustomOAuth2UserService customOAuth2UserService;

	//암호 인코더 > 필요(X)
	@Bean
	SecurityFilterChain filterchain(HttpSecurity http, OAuth2SuccessHandler OAuth2SuccessHandler) throws Exception {

		//CRSF > 비활성화
		http.csrf(auth -> auth.disable());

		//Form 로그인 방식(X) > 소셜 인증
		http.formLogin(auth -> auth.disable());

		//기본 인증 > 사용 안함
		http.httpBasic(auth -> auth.disable());

		//허가 URI
		http.authorizeHttpRequests(auth -> auth
			.requestMatchers("/").permitAll()
			.requestMatchers("/login/**").permitAll()
			.requestMatchers("/oauth2/**").permitAll()
			.anyRequest().authenticated()
		);

		//OAuth2 설정
		//- formLogin() > oauth2Login()
		http.oauth2Login(auth -> auth
			.loginPage("/login")
			.successHandler(OAuth2SuccessHandler)
			.userInfoEndpoint(config
						-> config.userService(customOAuth2UserService))
		);

		return http.build();
	}

}










