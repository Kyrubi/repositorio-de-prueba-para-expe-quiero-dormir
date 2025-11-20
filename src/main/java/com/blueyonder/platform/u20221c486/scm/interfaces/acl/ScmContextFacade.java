package com.blueyonder.platform.u20221c486.scm.interfaces.acl;

public interface ScmContextFacade {
    boolean existsInventoryItemBySkuIdentifier(String skuIdentifier);

    boolean isReadyForDispatch(String skuIdentifier, Double requestedQuantity);
}
