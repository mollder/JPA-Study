package org.ingue.jpa.domain.member.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberEmailDuplicateException extends RuntimeException {

    private static final String errorMsgPrefix = "cannot signup because member email : ";
    private static final String errorMsgPostFix = " is duplicated";

    public MemberEmailDuplicateException(String memberEmail) {
        super(errorMsgPrefix + memberEmail + errorMsgPostFix);
        log.info(errorMsgPrefix + memberEmail + errorMsgPostFix);
    }
}
