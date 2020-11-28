CREATE TABLE `study`.`member_chatroom_mapping` (
  `memberChatroomId`      BIGINT        NOT NULL AUTO_INCREMENT COMMENT '회원 대화방 매핑 아이디',
  `chatroomId`            BIGINT        NOT NULL                COMMENT '대화방 아이디',
  `memberId`              BIGINT        NOT NULL                COMMENT '회원 아이디',
  `chatroomName`          VARCHAR(60)   NOT NULL                COMMENT '대화방 이름',
  `joinAt`                DATETIME(6)   NOT NULL                COMMENT '대화방 참여 시간',
  `createdAt`             DATETIME(6)   NOT NULL                COMMENT '채팅 등록 일시',
  `modifiedAt`            DATETIME(6)   NOT NULL                COMMENT '채팅 수정 일시',
  PRIMARY KEY (`memberChatroomId`));