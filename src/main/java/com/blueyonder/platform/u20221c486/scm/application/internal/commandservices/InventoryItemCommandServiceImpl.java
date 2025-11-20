package com.blueyonder.platform.u20221c486.scm.application.internal.commandservices;

import com.blueyonder.platform.u20221c486.scm.domain.model.aggregates.InventoryItem;
import com.blueyonder.platform.u20221c486.scm.domain.model.commandservices.CreateInventoryItemCommand;
import com.blueyonder.platform.u20221c486.scm.domain.services.InventoryItemCommandService;
import com.blueyonder.platform.u20221c486.scm.infrastructure.persistence.jpa.repositories.InventoryItemRepository;
import com.blueyonder.platform.u20221c486.shared.domain.model.valueobjects.SkuIdentifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryItemCommandServiceImpl implements InventoryItemCommandService {
    private final InventoryItemRepository inventoryItemRepository;

    public InventoryItemCommandServiceImpl(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    @Override
    public Optional<InventoryItem> handle(CreateInventoryItemCommand command) {

        if (inventoryItemRepository.existsBySkuIdentifier(new SkuIdentifier(command.skuIdentifier()))){
            throw new IllegalArgumentException("Sku identifier already exists");
        }

        var inventoryItem = new InventoryItem(command.skuIdentifier(), command.minimumQuantity(), command.availableQuantity());

        try {
            inventoryItemRepository.save(inventoryItem);
            return Optional.of(inventoryItem);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to create inventory item: %s ".formatted(e.getMessage()));
        }
    }

}
