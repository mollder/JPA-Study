package org.ingue.jpa.domain.relationship;

import lombok.*;
import org.ingue.jpa.domain.member.Member;
import org.ingue.jpa.domain.support.CreatedAndModifiedEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RelationShip extends CreatedAndModifiedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relationShipId;
    private String friendName;

    @Enumerated(EnumType.STRING)
    private RelationShipStatus friendStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friendId")
    private Member friend;

    public static RelationShip cloneInstance(RelationShip relationShip) {
        return RelationShip.builder()
                .relationShipId(relationShip.getRelationShipId())
                .member(relationShip.getMember())
                .friend(relationShip.getFriend())
                .friendName(relationShip.getFriendName())
                .friendStatus(relationShip.getFriendStatus())
                .build();
    }
}
