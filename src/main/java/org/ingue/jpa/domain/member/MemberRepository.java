package org.ingue.jpa.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByMemberEmail(String memberEmail);
    Optional<Member> findByMemberKakaoId(String memberKakaoId);
}
