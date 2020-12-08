package org.ingue.jpa.domain

import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import org.ingue.jpa.domain.member.Member
import org.ingue.jpa.domain.member.MemberModifier
import org.ingue.jpa.domain.member.MemberRepository
import spock.lang.Shared
import spock.lang.Specification

class MemberModifierTests extends Specification {

    def memberModifier
    def memberRepository
    @Shared
    EnhancedRandom memberRandomBuilder

    def setupSpec() {
        memberRandomBuilder = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .stringLengthRange(3, 5)
                .collectionSizeRange(0, 0)
                .build();
    }

    def "조건에 맞는 Member가 들어오면 성공적으로 회원가입이 되야 합니다."() {
        given:
        def member = memberRandomBuilder.nextObject(Member.class, "memberId")

        def savedMember = Member.builder()
                .memberId(1)
                .memberPassword(member.memberPassword)
                .memberBirthDate(member.memberBirthDate)
                .memberChatroomMappings(member.memberChatroomMappings)
                .memberEmail(member.memberEmail)
                .memberKakaoId(member.memberKakaoId)
                .memberName(member.memberName)
                .memberProfileUrl(member.memberProfileUrl)
                .memberPhoneNumber(member.memberPhoneNumber)
                .memberStateMessage(member.memberStateMessage)
                .withdrawAt(member.withdrawAt)
                .build()

        memberRepository = Stub(MemberRepository.class)
        memberRepository.save(member) >> savedMember

        memberModifier = new MemberModifier(memberRepository)

        when:
        def result = memberModifier.signUp(member)

        then:
        result.memberId == 1
    }

}
