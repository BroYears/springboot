package com.test.basic;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.basic.board.BoardDAO;
import com.test.basic.board.CommentDAO;
import com.test.basic.config.TagDAO;
import com.test.basic.dto.Member;
import com.test.basic.dto.Student;
import com.test.basic.dto.User;

@SpringBootTest
class BuildTest {

	@Autowired
	private BoardDAO dao;
	
	@Autowired
	private CommentDAO cdao;
	
	@Autowired
	private TagDAO tdao;
	
	@Test
	void testBean() {
		assertNotNull(dao);
		assertNotNull(cdao);
		assertNotNull(tdao);
	}
	
	
	@Disabled
	@Test
	void test() {
		
		//빌더 패턴, Builder Pattern
		//- 복잡한 객체들을 단계별로 생성 할 수 있도록 하는 생성 디자인 패턴
		//- 복합 객체의 생성 과정과 표현 방법을 분리하여 동일한 생성 절차에서 서로 다른 표현 결과를 만들 수 있게 하는 패턴
		
		//생성자
		//- 인자의 개수와 순서, 이름을 파악 불편
		//- 다양한 생성 패턴 > 비용 발생 + 한계 발생(오버로딩)
		
		
		//Member 객체 [생성]!!
		Member m1 = new Member();
		
		m1.setSeq(1L);
		m1.setName("강아지");
		m1.setAge(2);
		m1.setAddress("서울시");
		m1.setGender("m");
		
		System.out.println(m1);
		
		Member m2 = new Member(2L, "고양이", 3, "인천시", "f");
		//Member [seq=2, name=고양이, age=3, address=인천시, gender=f]
		System.out.println(m2);
		
		
		Member m3 = new Member(3L, "병아리", "f");
		System.out.println(m3);
		
		User u1 = new User.Builder()
						.setSeq(4L)
						.setName("꿀꿀이")
						.setAge(3)
						.setAddress("부산시")
						.setGender("m")
						.build();
		//User 
		System.out.println(u1);

		User u2 = new User.Builder()
						.setSeq(5L)
						.setName("독수리")
						.setAddress("강릉시")
						.build();		
		System.out.println(u2);
		
		Student s1 = Student.builder()
						.seq(6L)
						.name("타조")
						.age(1)
						.address("제주시")
						.gender("f")
						.build()
						;
		System.out.println(s1);
		
		
		
		
	}
	

}








