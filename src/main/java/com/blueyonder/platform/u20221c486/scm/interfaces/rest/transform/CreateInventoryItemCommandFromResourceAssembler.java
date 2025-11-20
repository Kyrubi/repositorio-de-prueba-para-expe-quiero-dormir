package com.blueyonder.platform.u20221c486.scm.interfaces.rest.transform;

import com.blueyonder.platform.u20221c486.scm.domain.model.commandservices.CreateInventoryItemCommand;
import com.blueyonder.platform.u20221c486.scm.interfaces.rest.resources.CreateInventoryItemResource;

public class CreateInventoryItemCommandFromResourceAssembler {
    public static CreateInventoryItemCommand toCommandFromResource(CreateInventoryItemResource resource) {
        return new CreateInventoryItemCommand(
                resource.skuIdentifier(),
                resource.minimumQuantity(),
                resource.availableQuantity()
        );
    }
}
