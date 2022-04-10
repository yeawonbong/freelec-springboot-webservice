package org.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/* Posts 클래스로 Database를 접근하게 해 줄 Jpa Repository
** 보통 MyBatis에선 Dao라고 불리우는 DB Layer 접근자, JPA에서는 Repository라고 부르며, 인터페이스로 생성한다.
** 단순히 인터페이스를 생성 후, JpaRepository<Entity클래스, PK타입>을 상속하면 기본적인 CRUD 메소드가 자동으로 생성된다.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
