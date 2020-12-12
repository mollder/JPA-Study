package org.ingue.jpa.domain.member;

import lombok.*;
import org.ingue.jpa.domain.MemberChatroomMapping;
import org.ingue.jpa.domain.support.CreatedAndModifiedEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member extends CreatedAndModifiedEntity implements Cloneable {

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


}
