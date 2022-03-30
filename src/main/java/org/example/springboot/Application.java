package org.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//스프링부트의 자동설정, 스프링 Bean읽기와 생성 모두 자동으로 설정, SpringBootApplication이 있는 위치부터 서렂ㅇ을 읽어가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야 한다."
public class Application { //앞으로 만들 프로젝트의 메인 클래스
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // SpringBoot 내장 WAS 실행하게 된다
    }
}
