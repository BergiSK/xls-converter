package com.erste.acme.xlsconverter.core.poi;

import com.erste.acme.xlsconverter.domain.entity.Delivery;
import org.apache.poi.ss.usermodel.Row;

public interface RowMapper {

    Delivery mapToDelivery(Row row);
}
