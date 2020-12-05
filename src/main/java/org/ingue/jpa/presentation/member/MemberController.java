package org.ingue.jpa.presentation.member;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.ingue.jpa.domain.member.Member;
import org.ingue.jpa.domain.member.MemberFinder;
import org.ingue.jpa.domain.member.MemberModifier;
import org.ingue.jpa.presentation.member.dto.MemberSignUpDto;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberFinder memberFinder;
    private final MemberModifier memberModifier;

    @GetMapping("/{memberId}")
    @Operation(summary = "특정 유저 조회")
    public Member getMember(@PathVariable Long memberId) {
        return memberFinder.getMember(memberId);
    }

    @PostMapping
    @Operation(summary = "회원가입")
    public ResponseEntity signUp(@RequestBody @Valid MemberSignUpDto memberSignUpDto, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }

        Member member = memberSignUpDto.ToMember();

        WebMvcLinkBuilder linkBuilder = linkTo(MemberController.class).slash(member.getMemberId());

        return ResponseEntity.created(linkBuilder.toUri()).body(memberModifier.signUp(member));
    }
}
