package org.ingue.jpa.domain.member.exception;

import lombok.extern.slf4j.Slf4j;
import org.ingue.jpa.domain.member.Member;

@Slf4j
public class MemberEmailDuplicateException extends RuntimeException {

    private static final String errorMsgPrefix = "cannot signup because member email : ";
    private static final String errorMsgPostFix = " is duplicated";

    public MemberEmailDuplicateException(Member member) {
        super(errorMsgPrefix+member.getMemberEmail()+errorMsgPostFix);
        log.info(errorMsgPrefix+member.getMemberEmail()+errorMsgPostFix);
    }

    public MemberEmailDuplicateException(String msg) {
        super(msg);
    }
}
