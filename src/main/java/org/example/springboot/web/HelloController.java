package org.example.springboot.web;

import org.example.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어준다.
public class HelloController {

    @GetMapping("/hello") // HTTP Method인 Get 요청을 받을 수 있는 API를 만들어준다.
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    } // @RequestParam: 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션.
      //                  @RequestParam("[넘어오는 파라미터 이름]") [자료형][담을 변수]
      //                    외부에서 API로 넘어오는 파라미터를 담을 변수에 저장한다.
}
// 이제 이 프로젝트는 /hello로 요청이 오면 문자열 hello를 반환하는 기능을 갖게 된다.

