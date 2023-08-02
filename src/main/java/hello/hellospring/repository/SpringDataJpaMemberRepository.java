package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

// 스프링 데이터 JPA가 인터페이스를 보고 객체를 생성해서 빈을 자동으로 등록한다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>,
    MemberRepository {

  @Override
  Optional<Member> findByName(String name);
}
