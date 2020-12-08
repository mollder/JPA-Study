package org.ingue.jpa.presentation.member.dto.response;

import lombok.*;
import org.ingue.jpa.domain.member.Member;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberResponse {

    private final Long memberId;
    private final String memberName;
    private final String memberEmail;
    private final String memberStateMessage;
    private final String memberProfileUrl;
    private final LocalDate memberBirthDate;
    private final String memberPhoneNumber;
    private final String memberKakaoId;

    public static MemberResponse toMemberResponse(Member member) {
        return MemberResponse.builder()
                .memberId(member.getMemberId())
                .memberName(member.getMemberName())
                .memberEmail(member.getMemberEmail())
                .memberStateMessage(member.getMemberStateMessage())
                .memberProfileUrl(member.getMemberProfileUrl())
                .memberBirthDate(member.getMemberBirthDate())
                .memberPhoneNumber(member.getMemberPhoneNumber())
                .memberKakaoId(member.getMemberKakaoId())
                .build();
    }
}
