package org.ingue.jpa.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberModifier {

    private final MemberRepository memberRepository;
    private final MemberValidator memberValidator;

    //TODO : 테스트하기 어려운 코드를 Stub으로 쓰기 전에 테스트하기 쉬운 코드로 분리
    public Member signUp(Member member) {
        boolean emailExists = memberRepository.existsByMemberEmail(member.getMemberEmail());
        memberValidator.validateMemberSignUp(emailExists, member);

        return memberRepository.save(member);
    }
}
