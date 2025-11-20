package com.blueyonder.platform.u20221c486.scm.domain.model.valueobjects;

import lombok.Getter;

@Getter
public enum InventoryItemStatus {
    WITH_STOCK(0, "WITH_STOCK"),
    UNDER_MINIMUM(1, "UNDER_MINIMUM"),
    AUDITING(2, "AUDITING"),
    DISABLED(3, "DISABLED");

    private final int id;
    private final String option;

    InventoryItemStatus(int id, String option) {
        this.id = id;
        this.option = option;
    }

    public static InventoryItemStatus fromString(String value) {
        value = value.toUpperCase();
        for (InventoryItemStatus status : InventoryItemStatus.values()) {
            if (status.option.equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid InventoryItemStatus value: " + value);
    }

    public static InventoryItemStatus fromValue(int id) {
        for (InventoryItemStatus status : InventoryItemStatus.values()) {
            if (status.id == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid InventoryItemStatus id: " + id);
    }
}
