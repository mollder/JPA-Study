package org.ingue.jpa.domain.relationship;

import lombok.Getter;

@Getter
public enum RelationShipStatus {
    FRIEND("친구");

    String status;

    RelationShipStatus(String status) {
        this.status = status;
    }
}
