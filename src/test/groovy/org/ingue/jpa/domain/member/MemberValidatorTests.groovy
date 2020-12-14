package org.ingue.jpa.domain.member

import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import org.ingue.jpa.domain.member.exception.MemberEmailDuplicateException
import spock.lang.Shared
import spock.lang.Specification

class MemberValidatorTests extends Specification {

    @Shared
    MemberValidator memberValidator

    @Shared
    EnhancedRandom memberRandom

    def setupSpec() {
        memberValidator = new MemberValidator()
        memberRandom = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                            .stringLengthRange(3, 5)
                            .build()
    }

    def "이메일이 중복된 멤버가 들어오면 MemberEmailDuplicateError가 발생해야 합니다."() {
        given:
        def isEmailExist = true
        def member = memberRandom.nextObject(Member.class)

        when:
        memberValidator.validateMemberSignUp(isEmailExist, member)

        then:
        thrown(MemberEmailDuplicateException.class)
    }
}
