package com.erste.acme.xlsconverter.core.poi;

import com.erste.acme.commons.domain.entity.Category;
import com.erste.acme.commons.domain.entity.Delivery;
import com.erste.acme.commons.domain.entity.Product;
import com.erste.acme.xlsconverter.domain.core.ConversionService;
import com.erste.acme.xlsconverter.domain.exception.ReadXlsException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class PoiConversionService implements ConversionService {

    private static final int START_ENTRIES_INDEX_ROW = 1;

    private static final String DELIVERIES_SHEET_NAME = "Example List";

    private final RowMapper rowMapper;

    public PoiConversionService(RowMapper rowMapper) {
        this.rowMapper = rowMapper;
    }

    @Override
    public List<Product> getProducts(Resource inputResource) {
        return null;
    }

    @Override
    public List<Category> getCategories(Resource inputResource) {
        return null;
    }

    @Override
    public List<Delivery> getDeliveries(Resource inputResource) {
        XSSFWorkbook xlsInput = resourceToXls(inputResource);
        XSSFSheet deliverySheet = xlsInput.getSheet(DELIVERIES_SHEET_NAME);

        List<XSSFRow> deliveryRows = getSheetRows(deliverySheet);

        return deliveryRows.stream()
            .map(rowMapper::mapToDelivery)
            .collect(Collectors.toList());
    }

    private List<XSSFRow> getSheetRows(XSSFSheet deliverySheet) {
        return IntStream.range(START_ENTRIES_INDEX_ROW, deliverySheet.getLastRowNum())
            .mapToObj(index -> Optional.ofNullable(deliverySheet.getRow(index)))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
    }

    private XSSFWorkbook resourceToXls(Resource resource) {
        try {
            return new XSSFWorkbook(OPCPackage.open(resource.getInputStream()));
        } catch (Exception e) {
            throw new ReadXlsException("Could not read input xls file!", e);
        }
    }
}
