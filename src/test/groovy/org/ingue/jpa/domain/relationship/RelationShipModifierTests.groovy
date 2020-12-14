package org.ingue.jpa.domain.relationship

import io.github.benas.randombeans.EnhancedRandomBuilder
import org.ingue.jpa.domain.member.Member
import org.ingue.jpa.domain.member.MemberFinder
import org.ingue.jpa.domain.member.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import spock.lang.Shared
import spock.lang.Specification

@SpringBootTest
@Transactional
class RelationShipModifierTests extends Specification {

    @Autowired
    RelationShipModifier relationShipModifier

    @Autowired
    RelationShipRepository relationShipRepository

    @Autowired
    MemberFinder memberFinder

    @Autowired
    MemberRepository memberRepository

    @Shared
    def memberRandom

    def setupSpec() {
        memberRandom = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .stringLengthRange(3, 5)
                .build()
    }

    def "정상적인 카카오 id를 받아서 친구 추가를 하면 정상적으로 추가가 되야 한다."() {
        given:
        def mine = memberRandom.nextObject(Member.class)
        def friend = memberRandom.nextObject(Member.class, "memberKakaoId")
        def friendKakaoId = "friendKakaoId123"
        friend.memberKakaoId = friendKakaoId

        def savedMember = memberRepository.save(mine)
        memberRepository.save(friend)

        when:
        def result = relationShipModifier.addFriend(savedMember, friendKakaoId)

        then:
        result.getFriend().getMemberKakaoId() == friendKakaoId
    }
}
