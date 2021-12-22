package fpt.trainining.movietheatre.repository;

import fpt.trainining.movietheatre.entity.Account;
import fpt.trainining.movietheatre.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByMemberId(String memberId);

    Optional<Member> findByAccount(Account account);
}
