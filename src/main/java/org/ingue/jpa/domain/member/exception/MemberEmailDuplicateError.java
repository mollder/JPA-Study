package org.ingue.jpa.domain.member.exception;

public class MemberEmailDuplicateError extends RuntimeException {

    private static final String errorMsg = "cannot signup because member email is duplicated";

    public MemberEmailDuplicateError() {
        super(errorMsg);
    }

    public MemberEmailDuplicateError(String msg) {
        super(msg);
    }
}
