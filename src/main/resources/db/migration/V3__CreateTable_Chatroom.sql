CREATE TABLE `study`.`chatroom` (
  `chatroomId`            BIGINT        NOT NULL AUTO_INCREMENT COMMENT '대화방 아이디',
  `isDelete`              TINYINT(1)       NOT NULL                COMMENT '대화방 삭제 여부',
  `withdrawAt`            DATETIME(6)   NOT NULL                COMMENT '대화방 삭제 시간',
  `createdAt`             DATETIME(6)   NOT NULL                COMMENT '대화방 등록 일시',
  `modifiedAt`            DATETIME(6)   NOT NULL                COMMENT '대화방 수정 일시',
  PRIMARY KEY (`chatroomId`));