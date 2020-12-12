package org.ingue.jpa.presentation.member.advice;

import lombok.extern.slf4j.Slf4j;
import org.ingue.jpa.domain.member.exception.MemberEmailDuplicateException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class MemberControllerAdvice {

    @ExceptionHandler(MemberEmailDuplicateException.class)
    public ResponseEntity<String> memberEmailDuplicateException(MemberEmailDuplicateException e) {
        return ResponseEntity.status(500).body(e.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFoundException(EntityNotFoundException e) {
        return ResponseEntity.status(500).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exception(Exception e) {
        return ResponseEntity.status(500).body(e.getMessage());
    }
}
