package org.ingue.jpa.presentation.member

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import org.ingue.jpa.presentation.member.dto.request.MemberSignUpRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.transaction.annotation.Transactional
import spock.lang.Shared
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class MemberControllerTest extends Specification {

    @Autowired
    MockMvc mockMvc

    @Autowired
    ObjectMapper objectMapper

    @Shared
    EnhancedRandom enhancedRandom

    def setup() {
        enhancedRandom = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .stringLengthRange(3, 5)
                .build()
    }

    def "모든 필요조건을 만족하는 회원가입 요청이 들어왔을 때 성공적으로 회원가입 완료"() {
        given:
        def correctSignUpRequest = enhancedRandom.nextObject(MemberSignUpRequest.class, "memberEmail", "memberPhoneNum")
        correctSignUpRequest.memberEmail = "signup@email.com"
        correctSignUpRequest.memberPhoneNumber = "01000000000"

        expect:
        mockMvc.perform(post("/api/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(correctSignUpRequest)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("\$.memberId").exists())
                .andExpect(jsonPath("\$.memberName").value(correctSignUpRequest.memberName))
                .andExpect(jsonPath("\$.memberEmail").value(correctSignUpRequest.memberEmail))
                .andExpect(jsonPath("\$.memberStateMessage").value(null))
                .andExpect(jsonPath("\$.memberProfileUrl").value(null))
                .andExpect(jsonPath("\$.memberBirthDate").value(correctSignUpRequest.memberBirthDate.toString()))
                .andExpect(jsonPath("\$.memberPhoneNumber").value(correctSignUpRequest.memberPhoneNumber))
                .andExpect(jsonPath("\$.memberKakaoId").value(correctSignUpRequest.memberKakaoId))
    }

    def "모든 값에 null을 넣고 회원가입 요청이 들어오면 400 반환"() {
        given:
        def nullValuesSignUpRequest = new MemberSignUpRequest()

        expect:
        mockMvc.perform(post("/api/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(nullValuesSignUpRequest)))
                .andDo(print())
                .andExpect(status().isBadRequest())
    }

    def "email 형식을 지키지 않고 회원가입 요청이 들어오면 400 반환"() {
        given:
        def wrongEmailSignUpRequest = enhancedRandom
                .nextObject(MemberSignUpRequest.class, "memberEmail", "memberPhoneNumber")
        wrongEmailSignUpRequest.memberEmail = "wrongEmail"
        wrongEmailSignUpRequest.memberPhoneNumber = "01000000000"

        expect:
        mockMvc.perform(post("/api/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(wrongEmailSignUpRequest)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("\$[0].field").value("memberEmail"))
                .andExpect(jsonPath("\$[0].defaultMessage").value("must be a well-formed email address"))
    }
}
