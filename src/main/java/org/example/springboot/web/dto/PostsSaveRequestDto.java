package org.example.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.posts.Posts;

// Request의 데이터를 받을 Dto
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String autor;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.autor = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(autor)
                .build();
    }

}
