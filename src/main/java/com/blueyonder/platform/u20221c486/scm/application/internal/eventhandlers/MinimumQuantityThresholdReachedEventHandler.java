package com.blueyonder.platform.u20221c486.scm.application.internal.eventhandlers;

import com.blueyonder.platform.u20221c486.scm.domain.model.events.MinimumQuantityThresholdReachedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class MinimumQuantityThresholdReachedEventHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MinimumQuantityThresholdReachedEventHandler.class);

    @EventListener(MinimumQuantityThresholdReachedEvent.class)
    public void on(MinimumQuantityThresholdReachedEvent event) {
        LOGGER.info("SCM: A supply order is needed for the product with SKU {} with at least {} units",
                event.getSkuIdentifier().skuIdentifier(),
                event.getRequestedSupplyQuantity());
    }
}
