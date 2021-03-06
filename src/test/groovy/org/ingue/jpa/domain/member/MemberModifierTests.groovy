package org.ingue.jpa.domain.member

import io.github.benas.randombeans.EnhancedRandomBuilder
import org.ingue.jpa.domain.member.Member
import org.ingue.jpa.domain.member.MemberModifier
import org.ingue.jpa.domain.member.MemberRepository
import org.ingue.jpa.domain.member.exception.MemberEmailDuplicateException
import spock.lang.Shared
import spock.lang.Specification

class MemberModifierTests extends Specification {

    def memberRepository
    def memberModifier

    @Shared
    def memberRandom

    def setupSpec() {
        memberRandom = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .stringLengthRange(3, 5)
                .build()
    }

    def setup() {
        memberRepository = Stub(MemberRepository.class)
        memberModifier = new MemberModifier(memberRepository, new MemberValidator())
    }

    def "이메일이 중복되지 않은 멤버가 들어오면 성공적으로 회원가입이 되야 합니다."() {
        given:
        def member = memberRandom.nextObject(Member.class, "memberId")

        def savedMember = member.cloneInstance(member)
        savedMember.memberId = 1

        memberRepository.save(member) >> savedMember

        when:
        def result = memberModifier.signUp(member)

        then:
        result.memberId == 1
    }

    //TODO : 카카오 id duplicate 일 경우 들어가면 안됨
}
