package org.ingue.jpa.member;

import lombok.RequiredArgsConstructor;
import org.ingue.jpa.member.dto.MemberCreateDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberFinder memberFinder;

    @GetMapping("/{memberId}")
    public Member getMember(@PathVariable Long memberId) {
        return memberFinder.getMember(memberId);
    }

}
