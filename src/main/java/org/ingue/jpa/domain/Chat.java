package org.ingue.jpa.domain;

import lombok.*;
import org.ingue.jpa.domain.member.Member;
import org.ingue.jpa.domain.support.CreatedAndModifiedEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Chat extends CreatedAndModifiedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;
    private String chatMessage;
    private String chatStatus;
    private LocalDateTime withdrawAt;

    @ManyToOne
    @JoinColumn(name = "chatroomId")
    private Chatroom chatroom;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;
}
