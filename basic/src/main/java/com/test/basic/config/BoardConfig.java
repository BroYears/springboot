package com.test.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

	//<bean class="com.test.basic.board.TagDAO">
	// <property name="age" ref="adto"/>
	//</bean>
	@Bean
	public TagDAO getTagDAO() {

		
		return new TagDAO();
	}
	
}
