package com.blueyonder.platform.u20221c486.scm.infrastructure.persistence.jpa.repositories;

import com.blueyonder.platform.u20221c486.scm.domain.model.aggregates.InventoryItem;
import com.blueyonder.platform.u20221c486.shared.domain.model.valueobjects.SkuIdentifier;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
    Optional<InventoryItem> findBySkuIdentifier(SkuIdentifier skuIdentifier);
    boolean existsBySkuIdentifier(SkuIdentifier skuIdentifier);
}
