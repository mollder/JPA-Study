package org.ingue.jpa

import io.github.benas.randombeans.EnhancedRandomBuilder
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import java.lang.reflect.Member

class MemberFinderTest extends Specification {

    def "테스트"() {
        def memberBuilder = EnhancedRandomBuilder
            .aNewEnhancedRandomBuilder()
            .stringLengthRange(3, 5)
            .collectionSizeRange(0, 0)
            .build()

        println memberBuilder.nextObject(Member.class)
    }
}
