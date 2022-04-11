package org.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //lombok의 어노테이션 - 코드를 단순화시켜주지만, 필수 어노테이션은 아님, 모든 필드에 Getter 생성
@NoArgsConstructor //lombok의 어노테이션 - 기본 생성자 자동 추가 - `public Posts(){}`
@Entity //JPA의 어노테이션 - DB 테이블과 링크될 클래스임을 나타낸다.
public class Posts {  // 실제 DB의 테이블과 매칭될 클래스, 보통 Entity클래스라고도 한다. JPA를 사용하면 DB 데이터에 작업할 경우 실제 쿼리를 날리기보다, 이 Entity 클래스의 수정을 통해 작업한다.

    @Id // 해당 테이블의 PK 필드를 나타낸다.
    @GeneratedValue(strategy =  GenerationType.IDENTITY) // PK의 생성 규칙을 나타낸다.
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 column을 나타내며, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 된다. 기본값 외에 추가로 변경이 필요한 옵션이 있을 때 사용한다. (기본 255를 500length로 변경하는 등)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    /*
        Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다!
        기본적인 구조는 생성자를 통해 최종값을 채운 후 DB에 insert하는 것이며, 값 변경이 필요한 경우 해당 이벤트에 맞는 public 메소드를 호출하여 변경하는 것을 전제로 한다.
        본 예제에서는 생성자 대신 @Builder를 통해 제공되는 빌더 클래스를 사용한다.
     */

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
