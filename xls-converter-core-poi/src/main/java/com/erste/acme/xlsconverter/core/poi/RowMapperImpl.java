package com.erste.acme.xlsconverter.core.poi;

import com.erste.acme.xlsconverter.domain.entity.Delivery;
import com.erste.acme.xlsconverter.domain.entity.Product;
import com.erste.acme.xlsconverter.domain.exception.XlsConverterException;
import java.util.Date;
import java.util.Optional;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

@Component
public class RowMapperImpl implements RowMapper {

    public Delivery mapToDelivery(Row row) {
        Product product = Product.builder().name(getProductName(row)).build();
        Date deliveryDate = getDate(row);

        return Delivery.builder()
            .amount(getAmount(row).longValue())
            .product(product)
            .date(deliveryDate)
            .build();
    }

    private String getProductName(Row row) {
        return getCell(row, DeliveryTableColumns.PRODUCT_NAME.getIndexColumn()).getStringCellValue();
    }

    private Date getDate(Row row) {
        return getCell(row, DeliveryTableColumns.DATE.getIndexColumn()).getDateCellValue();
    }

    private Double getAmount(Row row) {
        return getCell(row, DeliveryTableColumns.AMOUNT.getIndexColumn()).getNumericCellValue();
    }

    private Cell getCell(Row row, int columnIndex) {
        return Optional.ofNullable(row.getCell(columnIndex))
            .orElseThrow(() -> new XlsConverterException(String.format("Missing xls data in column: %s, row: %s", columnIndex, row.getRowNum())));
    }
}
