package com.erste.acme.xlsconverter.core.poi;

public enum DeliveryTableColumns {

    DATE(0),
    PRODUCT_NAME(1),
    AMOUNT(2);

    private final int indexColumn;

    DeliveryTableColumns(int indexColumn) {
        this.indexColumn = indexColumn;
    }

    public int getIndexColumn() {
        return indexColumn;
    }
}
