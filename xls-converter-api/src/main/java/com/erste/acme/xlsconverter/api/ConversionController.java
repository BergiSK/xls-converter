package com.erste.acme.xlsconverter.api;

import com.erste.acme.xlsconverter.api.dto.ApiDtoMapper;
import com.erste.acme.xlsconverter.api.dto.DeliveryDto;
import com.erste.acme.xlsconverter.domain.core.ConversionService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "converter")
@RestController
@RequestMapping("/converter")
public class ConversionController {

    private final ConversionService conversionService;

    private final ApiDtoMapper apiDtoMapper;

    @Autowired
    public ConversionController(ConversionService conversionService, ApiDtoMapper apiDtoMapper) {
        this.conversionService = conversionService;
        this.apiDtoMapper = apiDtoMapper;
    }

    @ApiResponse(responseCode = "200", description = "Converts input delivery data from xls to json format",
        content = @Content(
            mediaType = MediaType.APPLICATION_JSON_VALUE,
            array = @ArraySchema(schema = @Schema(implementation = DeliveryDto.class))
        ))
    @RequestMapping(value = "/deliveries",
        produces = { "application/json" },
        consumes = { "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" },
        method = RequestMethod.POST)
    public ResponseEntity<List<DeliveryDto>> getDeliveries(@RequestBody Resource inputResource) {
        List<DeliveryDto> deliveries = conversionService.getDeliveries(inputResource)
            .stream()
            .map(apiDtoMapper::toDeliveryDto)
            .collect(Collectors.toList());

        return ResponseEntity.ok(deliveries);
    }
}
