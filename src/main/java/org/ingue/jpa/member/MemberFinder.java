package org.ingue.jpa.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberFinder {

    private final MemberRepository memberRepository;

    public Member getMember(Long memberId) {
        Optional<Member> byId = memberRepository.findById(memberId);

        if (!byId.isPresent()) {
            throw new EntityNotFoundException(memberId + " is not found");
        }

        return byId.get();
    }
}
