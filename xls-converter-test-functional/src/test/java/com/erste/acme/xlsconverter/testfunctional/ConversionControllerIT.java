package com.erste.acme.xlsconverter.testfunctional;

import io.restassured.RestAssured;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ConversionControllerIT {

    @BeforeAll
    static void beforeClass() {
        Wait.untilConverterUp();
    }

    @Test
    void testConvertXlsToDeliveries() {
        InputStream xlsFile = ConversionControllerIT.class.getClassLoader().getResourceAsStream("DataSet_ACME.xlsx");
        RestAssured.given().baseUri("http://localhost:8080")
            .contentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
            .body(xlsFile)
            .post("/converter/deliveries")
            .then()
            .statusCode(200);
    }

}
