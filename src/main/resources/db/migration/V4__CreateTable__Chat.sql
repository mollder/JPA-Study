CREATE TABLE `study`.`chat` (
  `chatId`                BIGINT        NOT NULL AUTO_INCREMENT COMMENT '채팅 아이디',
  `chatroomId`            BIGINT        NOT NULL                COMMENT '대화방 아이디',
  `memberId`              BIGINT        NOT NULL                COMMENT '회원 아이디',
  `chatMessage`           VARCHAR(1000) NOT NULL                COMMENT '채팅 메시지',
  `chatStatus`            VARCHAR(10)   NOT NULL                COMMENT '채팅 상태',
  `withdrawAt`            DATETIME(6)   NOT NULL                COMMENT '채팅 삭제 시간',
  `createdAt`             DATETIME(6)   NOT NULL                COMMENT '채팅 등록 일시',
  `modifiedAt`            DATETIME(6)   NOT NULL                COMMENT '채팅 수정 일시',
  PRIMARY KEY (`chatId`));