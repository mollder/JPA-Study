package org.ingue.jpa.domain;

import com.mysql.cj.jdbc.Driver;
import lombok.*;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.ingue.jpa.domain.support.CreatedAndModifiedEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Chat extends CreatedAndModifiedEntity {

    @Id
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
