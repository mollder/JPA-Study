package org.ingue.jpa.domain.relationship;

import lombok.RequiredArgsConstructor;
import org.ingue.jpa.domain.member.Member;
import org.ingue.jpa.domain.member.MemberFinder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RelationShipModifier {

    private final RelationShipRepository relationShipRepository;
    private final MemberFinder memberFinder;

    public RelationShip addFriend(Member mind, String friendKakaoId) {
        Member friend = memberFinder.getMemberByMemberKakaoId(friendKakaoId);

        RelationShip relationship = RelationShip.builder()
                .member(mind)
                .friend(friend)
                .friendName(friend.getMemberName())
                .friendStatus(RelationShipStatus.FRIEND)
                .build();

        return relationShipRepository.save(relationship);
    }
}
