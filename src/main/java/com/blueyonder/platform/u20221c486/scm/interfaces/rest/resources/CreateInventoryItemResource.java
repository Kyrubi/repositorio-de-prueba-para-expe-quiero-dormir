package com.blueyonder.platform.u20221c486.scm.interfaces.rest.resources;

public record CreateInventoryItemResource(
        String skuIdentifier,
        Double minimumQuantity,
        Double availableQuantity
) {
}
