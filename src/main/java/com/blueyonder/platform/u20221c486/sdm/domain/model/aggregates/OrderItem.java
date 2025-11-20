package com.blueyonder.platform.u20221c486.sdm.domain.model.aggregates;


import com.blueyonder.platform.u20221c486.sdm.domain.model.valueobjects.OrderItemStatus;
import com.blueyonder.platform.u20221c486.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.blueyonder.platform.u20221c486.shared.domain.model.valueobjects.SkuIdentifier;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
public class OrderItem extends AuditableAbstractAggregateRoot<OrderItem> {
    @Min(1)
    @NotNull
    @Column(nullable = false)
    private Long OrderId;

    @Embedded
    @NotNull
    @Column(nullable = false)
    private SkuIdentifier skuIdentifier;

    @NotNull
    @DecimalMin(value = "0.00", inclusive = false)
    @Column(nullable = false)
    private Double requestedQuantity;

    @NotNull
    @Column(nullable = false)
    private OrderItemStatus status;

    @NotNull
    @Column(nullable = false)
    private Date orderedAt;


}
