package com.blueyonder.platform.u20221c486.scm.domain.model.aggregates;

import com.blueyonder.platform.u20221c486.scm.domain.model.valueobjects.InventoryItemStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class InventoryItemTest {

    @Test
    @DisplayName("Should correctly create an InventoryItem using constructor")
    void shouldCreateInventoryItem() {
        // Arrange
        String sku = UUID.randomUUID().toString();

        // Act
        InventoryItem item = new InventoryItem(sku, 10.0, 20.0);

        // Assert
        assertNotNull(item);
        assertEquals(sku, item.getSkuIdentifier().skuIdentifier());
        assertEquals(10.0, item.getMinimumQuantity());
        assertEquals(20.0, item.getAvailableQuantity());
        assertEquals(InventoryItemStatus.WITH_STOCK, item.getStatus());
        assertEquals(0.0, item.getReservedQuantity());
        assertEquals(0.0, item.getPendingSupplyQuantity());
    }

    @Test
    @DisplayName("Should process dispatch request successfully when stock is enough")
    void shouldProcessDispatchRequestSuccessfully() {
        // Arrange
        InventoryItem item = new InventoryItem(UUID.randomUUID().toString(), 5.0, 20.0);

        // Act
        boolean result = item.processDispatchRequest(8.0);

        // Assert
        assertTrue(result);
        assertEquals(12.0, item.getAvailableQuantity());
        assertEquals(8.0, item.getReservedQuantity());
        assertEquals(0.0, item.getPendingSupplyQuantity());
        assertEquals(InventoryItemStatus.WITH_STOCK, item.getStatus());
    }

    @Test
    @DisplayName("Should handle dispatch request with insufficient stock")
    void shouldHandleDispatchRequestWithShortage() {
        // Arrange
        InventoryItem item = new InventoryItem(UUID.randomUUID().toString(), 5.0, 6.0);

        // Act
        boolean result = item.processDispatchRequest(10.0);

        // Assert
        assertFalse(result);
        assertEquals(0.0, item.getAvailableQuantity());
        assertEquals(0.0, item.getReservedQuantity());
        assertEquals(4.0, item.getPendingSupplyQuantity());  // 10 - 6
    }

    @Test
    @DisplayName("Should change status to UNDER_MINIMUM when quantity goes below threshold")
    void shouldChangeStatusToUnderMinimum() {
        // Arrange
        InventoryItem item = new InventoryItem(UUID.randomUUID().toString(), 10.0, 15.0);

        // Act
        item.updateAvailableQuantity(5.0);

        // Assert
        assertEquals(InventoryItemStatus.UNDER_MINIMUM, item.getStatus());
    }
}
