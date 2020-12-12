package org.ingue.jpa.domain.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberFinder {

    private final MemberRepository memberRepository;

    public Member getMember(Long memberId) {
        return memberRepository
                .findById(memberId)
                .orElseThrow(() -> {
                    log.error("memberId : "+memberId+" throw entity not found exception");
                    //TODO : 이게 왜 throw가 아닌 리턴인지 공부
                    return new EntityNotFoundException(memberId + " is not found");
                });
    }
}
