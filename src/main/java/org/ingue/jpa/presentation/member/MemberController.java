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
    //TODO MemberResponnse 객체 작업 ( 도메인 반환하는 것보다 더 좋아보임 )
    public Member getMember(@PathVariable Long memberId) {
        return memberFinder.getMember(memberId);
    }

    @PostMapping
    @Operation(summary = "회원가입")
    public ResponseEntity signUp(@RequestBody @Valid MemberSignUpDto memberSignUpDto, Errors errors) {
        //TODO : @Valid로 돌려줄 때 모든 에러 사항을 전부 돌려주는지 아니면 일부분만 돌려주는지 확인
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }

        Member member = memberSignUpDto.toMember();

        WebMvcLinkBuilder linkBuilder = linkTo(MemberController.class).slash(member.getMemberId());

        //TODO : ResponseEntity.status() 메소드 공부
        return ResponseEntity.created(linkBuilder.toUri()).body(memberModifier.signUp(member));
    }
}
