package org.example.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언된 모든 필드의 getter를 생성해준다.
@RequiredArgsConstructor // 선언된 모든 final필드가 포함된 생성자를 생성해준다. (final이 없는 ㅣㄹ드는 생성자에 포함되지 않는다.)
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
