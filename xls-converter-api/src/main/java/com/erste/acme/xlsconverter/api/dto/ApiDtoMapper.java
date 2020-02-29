package com.erste.acme.xlsconverter.api.dto;

import static org.mapstruct.ReportingPolicy.ERROR;

import com.erste.acme.xlsconverter.domain.entity.Category;
import com.erste.acme.xlsconverter.domain.entity.Delivery;
import com.erste.acme.xlsconverter.domain.entity.Product;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ERROR)
public interface ApiDtoMapper {

    DeliveryDto toDeliveryDto(Delivery delivery);

    ProductDto toProductDto(Product product);

    CategoryDto toCategoryDto(Category category);

    default <T> T unwrapOptional(Optional<T> optional) {
        return optional.orElse(null);
    }
}
