package org.ingue.jpa.domain;

import lombok.*;
import org.ingue.jpa.domain.support.CreatedAndModifiedEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Chatroom extends CreatedAndModifiedEntity {

    @Id
    private Long chatroomId;
    private boolean isDelete;
    private LocalDateTime withdrawAt;

    @OneToMany(
            mappedBy = "member",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MemberChatroomMapping> memberChatroomMappings = new ArrayList<>();
}
