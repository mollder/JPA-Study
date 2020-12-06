package org.ingue.jpa.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class MemberFinder {

    private final MemberRepository memberRepository;

    public Member getMember(Long memberId) {
        return memberRepository
                .findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException(memberId + " is not found"));
    }
}
