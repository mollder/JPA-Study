CREATE TABLE `study`.`relationship` (
  `relationshipId`        BIGINT        NOT NULL AUTO_INCREMENT COMMENT '관계 아이디',
  `memberId`              BIGINT        NOT NULL                COMMENT '회원 아이디',
  `friendId`              BIGINT        NOT NULL                COMMENT '친구 아이디',
  `friendName`            VARCHAR(50)   NOT NULL                COMMENT '친구 이름',
  `friendStatus`          VARCHAR(20)   NOT NULL                COMMENT '친구 상태',
  `createdAt`             DATETIME(6)   NOT NULL                COMMENT '관계 등록 일시',
  `modifiedAt`            DATETIME(6)   NOT NULL                COMMENT '관계 수정 일시',
  PRIMARY KEY (`relationshipId`));