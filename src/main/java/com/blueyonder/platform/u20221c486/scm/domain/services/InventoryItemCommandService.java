package com.blueyonder.platform.u20221c486.scm.domain.services;

import com.blueyonder.platform.u20221c486.scm.domain.model.aggregates.InventoryItem;
import com.blueyonder.platform.u20221c486.scm.domain.model.commandservices.CreateInventoryItemCommand;

import java.util.Optional;

public interface InventoryItemCommandService {
    Optional<InventoryItem> handle(CreateInventoryItemCommand command);
}
