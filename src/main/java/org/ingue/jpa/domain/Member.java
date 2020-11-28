package org.ingue.jpa.domain;

import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.ingue.jpa.domain.support.CreatedAndModifiedEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
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

    @NaturalId
    private String memberKakaoId;
    private LocalDateTime withdrawAt;

    @OneToMany(
            mappedBy = "member",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MemberChatroomMapping> memberChatroomMappings = new ArrayList<>();
}
