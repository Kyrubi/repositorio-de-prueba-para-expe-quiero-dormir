package com.blueyonder.platform.u20221c486.sdm.domain.model.valueobjects;

import lombok.Getter;

@Getter
public enum OrderItemStatus {
    READY_FOR_DISPATCH(0, "READY_FOR_DISPATCH"),
    WAITING_FOR_INVENTORY(1, "WAITING_FOR_INVENTORY"),
    DISPATCHING(2, "DISPATCHING"),
    COMPLETED(3, "COMPLETED");

    private final int id;
    private final String option;

    OrderItemStatus(int id, String option) {
        this.id = id;
        this.option = option;
    }

    public static OrderItemStatus fromString(String value) {
        value = value.toUpperCase();
        for (OrderItemStatus status : OrderItemStatus.values()) {
            if (status.option.equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid InventoryItemStatus value: " + value);
    }

    public static OrderItemStatus fromValue(int id) {
        for (OrderItemStatus status : OrderItemStatus.values()) {
            if (status.id == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid InventoryItemStatus id: " + id);
    }
}
