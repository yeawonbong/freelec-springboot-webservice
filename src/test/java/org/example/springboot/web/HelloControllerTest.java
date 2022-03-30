package org.example.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // 1
@WebMvcTest(controllers = HelloController.class) // 2
public class HelloControllerTest {

    @Autowired // 3. 스프링이 관리하는 빈(Bean)을 주입받는다.
    private MockMvc mvc; // 4

    @Test
    public void return_hello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // 5.  MockMvc를 통해 /hello 주소로 HTTP GET 요청을 한다.
                .andExpect(status().isOk()) // 6.  mvc.perform의 결과를 검증한다 - HTTP Header Status 검증
                .andExpect(content().string(hello)); // 7.  mvc.perform의 결과를 검증 - 응답 본문의 내용을 검증
    }

    @Test
    public void return_helloDto() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name) // param: API 테스트 할 때 사용될 요청 파라미터 설정, 단 값은 String만 허용한다.
                        .param("amount", String.valueOf(amount)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", is(name))) // jsonPath: JSON 응답값을 필드별로 검증할 수 있는 메소드. $.를 기준으로 필드명을 명시.
            .andExpect(jsonPath("$.amount", is(amount)));

    }
}

/*
1.  테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다. 여기서는 SpringRunner라는 스프링 실행자.
    즉, 스프링 부트 테스트와 JUnit 사이의 연결자 역할을 한다.
2.  여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션
4.  웹 API를 테스트 할 때 사용, 스프링 MVC 테스트의 시작점이다. 이 클래스를 통해 HTTPGET, POST 등에 대한 API 테스트를 할 수 있다.
6.  mvc.perform의 결과를 검증한다. HTTP Header의 Status를 검증한다. (흔히 아는 200 400 500 등의 상태를 검증)
    여기서는 200 (OK)가 맞는 지 검증
7.  mvc.perform의 결과를 검증 - 응답 본문의 내용을 검증
    여기서는 "hello"리턴한 값이 맞는 지 검증
 */