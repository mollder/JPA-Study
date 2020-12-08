package org.ingue.jpa.domain

import io.github.benas.randombeans.EnhancedRandomBuilder
import org.ingue.jpa.domain.member.Member
import org.ingue.jpa.domain.member.MemberModifier
import org.ingue.jpa.domain.member.MemberRepository
import org.ingue.jpa.domain.member.exception.MemberEmailDuplicateError
import spock.lang.Shared
import spock.lang.Specification

class MemberModifierTests extends Specification {

    @Shared
    def memberRandomBuilder
    def memberModifier
    def memberRepository

    def setupSpec() {
        memberRandomBuilder = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .stringLengthRange(3, 5)
                .collectionSizeRange(0, 0)
                .build();
    }

    def "이메일이 중복되지 않은 멤버가 들어오면 성공적으로 회원가입이 되야 합니다."() {
        given:
        def member = memberRandomBuilder.nextObject(Member.class, "memberId")

        def savedMember = member.clone()
        savedMember.memberId = 1

        memberRepository = Stub(MemberRepository.class)
        memberRepository.save(member) >> savedMember

        memberModifier = new MemberModifier(memberRepository)

        when:
        def result = memberModifier.signUp(member)

        then:
        result.memberId == 1
    }

    def "이메일이 중복된 멤버가 들어오면 MemberEmailDuplicateError가 발생해야 합니다."() {
        given:
        def emailDuplicatedMember = memberRandomBuilder
                .nextObject(Member.class, "memberId")

        memberRepository = Stub(MemberRepository.class)
        memberRepository.existsByMemberEmail(emailDuplicatedMember.getMemberEmail()) >> true

        memberModifier = new MemberModifier(memberRepository)

        when:
        memberModifier.signUp(emailDuplicatedMember)

        then:
        thrown(MemberEmailDuplicateError.class)
    }

}
