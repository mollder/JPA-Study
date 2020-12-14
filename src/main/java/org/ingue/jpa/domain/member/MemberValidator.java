package org.ingue.jpa.domain.member;

import org.ingue.jpa.domain.member.exception.MemberEmailDuplicateException;
import org.springframework.stereotype.Service;

@Service
public class MemberValidator {

    public void validateMemberSignUp(boolean isEmailExist, Member member) {
        if(isEmailExist) {
            throw new MemberEmailDuplicateException(member.getMemberEmail());
        }
    }
}
