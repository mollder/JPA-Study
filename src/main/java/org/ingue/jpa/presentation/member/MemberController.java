package org.ingue.jpa.presentation.member;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.ingue.jpa.domain.member.Member;
import org.ingue.jpa.domain.member.MemberFinder;
import org.ingue.jpa.domain.member.MemberModifier;
import org.ingue.jpa.presentation.member.dto.request.MemberSignUpRequest;
import org.ingue.jpa.presentation.member.dto.response.MemberResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberFinder memberFinder;
    private final MemberModifier memberModifier;

    @GetMapping("/{memberId}")
    public MemberResponse getMember(@PathVariable Long memberId) {
        Member findMember = memberFinder.getMember(memberId);

        return MemberResponse.toMemberResponse(findMember);
    }

    @PostMapping
    public ResponseEntity signUp(@RequestBody @Valid MemberSignUpRequest memberSignUpRequest, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }

        Member member = memberSignUpRequest.toMember();
        Member signedMember = memberModifier.signUp(member);

        return ResponseEntity.status(201).body(MemberResponse.toMemberResponse(signedMember));
    }
}
