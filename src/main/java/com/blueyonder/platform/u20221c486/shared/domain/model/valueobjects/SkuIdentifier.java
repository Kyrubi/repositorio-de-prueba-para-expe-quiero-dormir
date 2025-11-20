package com.blueyonder.platform.u20221c486.shared.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record SkuIdentifier(String skuIdentifier) {
    public SkuIdentifier {
        if (skuIdentifier == null || skuIdentifier.isEmpty()) {
            throw new IllegalArgumentException("SKU Identifier must not be null or empty");
        }
        try {
            UUID.fromString(skuIdentifier);
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("SKU Identifier is invalid");
        }
    }
}
