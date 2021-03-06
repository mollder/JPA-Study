package org.ingue.jpa.domain.member

import io.github.benas.randombeans.EnhancedRandomBuilder
import org.ingue.jpa.domain.member.Member
import org.ingue.jpa.domain.member.MemberFinder
import org.ingue.jpa.domain.member.MemberRepository
import spock.lang.Shared
import spock.lang.Specification

import javax.persistence.EntityNotFoundException

class MemberFinderTests extends Specification {

    def memberFinder
    def memberRepository

    @Shared
    def memberRandom

    def setupSpec() {
        memberRandom = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .stringLengthRange(3, 5)
                .build()
    }

    def setup() {
        memberRepository = Stub(MemberRepository.class)
        memberFinder = new MemberFinder(memberRepository)
    }

    def "getMemberByMemberId 메소드를 이용하여 원하는 멤버를 찾지 못하면 EntityNotFoundException 발생"() {
        given:
        def notExistMemberId = 1

        memberRepository.findById(notExistMemberId) >> Optional.empty()

        when:
        memberFinder.getMemberByMemberId(notExistMemberId)

        then:
        thrown(EntityNotFoundException.class)
    }

    def "getMemberByMemberId 메소드를 이용하여 원하는 멤버를 찾으면 정상적으로 멤버를 반환"() {
        given:
        def member = memberRandom.nextObject(Member.class)

        memberRepository.findById(member.memberId) >> Optional.of(member)

        when:
        def result = memberFinder.getMemberByMemberId(member.memberId)

        then:
        result == member
    }

    def "getMemberByMemberKakaoId 메소드를 이용하여 원하는 멤버를 찾지 못하면 EntityNotFoundException 발생"() {
        given:
        def notExistMemberKakaoId = "notExistKakaoId"

        memberRepository.findByMemberKakaoId(notExistMemberKakaoId) >> Optional.empty()

        when:
        memberFinder.getMemberByMemberKakaoId(notExistMemberKakaoId)

        then:
        thrown(EntityNotFoundException.class)
    }

    def "getMemberByMemberKakaoId 메소드를 이용하여 원하는 멤버를 찾으면 정상적으로 멤버를 반환"() {
        given:
        def member = memberRandom.nextObject(Member.class)

        memberRepository.findByMemberKakaoId(member.memberKakaoId) >> Optional.of(member)

        when:
        def result = memberFinder.getMemberByMemberKakaoId(member.memberKakaoId)

        then:
        result == member
    }
}
