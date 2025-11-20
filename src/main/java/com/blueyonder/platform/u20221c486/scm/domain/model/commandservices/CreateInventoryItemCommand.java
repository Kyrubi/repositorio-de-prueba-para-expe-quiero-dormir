package com.blueyonder.platform.u20221c486.scm.domain.model.commandservices;

public record CreateInventoryItemCommand(
        String skuIdentifier,
        Double minimumQuantity,
        Double availableQuantity
) {
    public CreateInventoryItemCommand {
        if (skuIdentifier == null || skuIdentifier.isBlank()) {
            throw new IllegalArgumentException("SKU identifier must not be null or blank");
        }
        if (minimumQuantity == null || minimumQuantity <= 10) {
            throw new IllegalArgumentException("Minimum quantity must not be null or less than ten");
        }
        if (availableQuantity == null || availableQuantity < minimumQuantity * 3) {
            throw new IllegalArgumentException("Available quantity must not be null or less than the triple of minimum quantity");
        }
    }
}
