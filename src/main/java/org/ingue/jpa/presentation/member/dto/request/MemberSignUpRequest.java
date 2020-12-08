package org.ingue.jpa.presentation.member.dto.request;

import lombok.*;
import org.ingue.jpa.domain.member.Member;
import org.ingue.jpa.presentation.member.support.validator.PhoneNum;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@ToString
public class MemberSignUpRequest {

    @NotEmpty
    private String memberPassword;

    @NotEmpty
    private String memberName;

    @NotEmpty
    @Email
    private String memberEmail;

    @NotNull
    private LocalDate memberBirthDate;

    @PhoneNum
    private String memberPhoneNumber;

    @NotEmpty
    private String memberKakaoId;

    public Member toMember() {
        return Member.builder()
                .memberPassword(memberPassword)
                .memberName(memberName)
                .memberEmail(memberEmail)
                .memberBirthDate(memberBirthDate)
                .memberPhoneNumber(memberPhoneNumber)
                .memberKakaoId(memberKakaoId)
                .build();
    }
}
