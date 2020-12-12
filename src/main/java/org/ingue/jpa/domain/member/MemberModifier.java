package org.ingue.jpa.domain.member;

import lombok.RequiredArgsConstructor;
import org.ingue.jpa.domain.member.exception.MemberEmailDuplicateException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberModifier {

    private final MemberRepository memberRepository;

    public Member signUp(Member member) {
        boolean emailExists = memberRepository.existsByMemberEmail(member.getMemberEmail());

        if (emailExists) {
            throw new MemberEmailDuplicateException(member);
        }

        return memberRepository.save(member);
    }
}
