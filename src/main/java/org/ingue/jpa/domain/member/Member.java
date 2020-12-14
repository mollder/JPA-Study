package org.ingue.jpa.domain.member;

import lombok.*;
import org.ingue.jpa.domain.support.CreatedAndModifiedEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member extends CreatedAndModifiedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String memberPassword;
    private String memberName;
    private String memberEmail;
    private String memberStateMessage;
    private String memberProfileUrl;
    private LocalDate memberBirthDate;
    private String memberPhoneNumber;
    private String memberKakaoId;
    private LocalDateTime withdrawAt;

    public static Member cloneInstance(Member member) {
        return Member.builder()
                .memberId(member.getMemberId())
                .memberPassword(member.getMemberPassword())
                .memberName(member.getMemberName())
                .memberEmail(member.getMemberEmail())
                .memberStateMessage(member.getMemberStateMessage())
                .memberProfileUrl(member.getMemberProfileUrl())
                .memberBirthDate(member.getMemberBirthDate())
                .memberPhoneNumber(member.getMemberPhoneNumber())
                .memberKakaoId(member.getMemberKakaoId())
                .withdrawAt(member.getWithdrawAt())
                .build();
    }
}
