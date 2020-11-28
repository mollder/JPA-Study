package org.ingue.jpa.domain;

import lombok.*;
import org.ingue.jpa.domain.support.CreatedAndModifiedEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Relationship extends CreatedAndModifiedEntity {

    @Id
    private Long relationshipId;
    private String friendName;
    private String friendStatus;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "friendId")
    private Member friend;
}
