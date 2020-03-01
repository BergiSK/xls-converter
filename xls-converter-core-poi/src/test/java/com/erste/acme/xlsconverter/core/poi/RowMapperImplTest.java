package com.erste.acme.xlsconverter.core.poi;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.erste.acme.commons.domain.entity.Delivery;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RowMapperImplTest {

    private RowMapper rowMapper = new RowMapperImpl();

    @Test
    void mapToDelivery() {
        Date now = new Date();
        Row row = getTestRow(now);

        Delivery delivery = rowMapper.mapToDelivery(row);

        assertEquals(100, delivery.getAmount());
        assertEquals("testProduct", delivery.getProduct().getName());
        assertEquals(now, delivery.getDate());
    }

    private Row getTestRow(Date date) {
        Row row = Mockito.mock(Row.class);
        Cell cell = Mockito.mock(Cell.class);

        when(cell.getStringCellValue()).thenReturn("testProduct");
        when(cell.getNumericCellValue()).thenReturn(100.0);
        when(cell.getDateCellValue()).thenReturn(date);
        when(row.getCell(anyInt())).thenReturn(cell);

        return row;
    }
}