package com.erste.acme.xlsconverter.api.dto;

import static org.mapstruct.ReportingPolicy.ERROR;

import com.erste.acme.commons.domain.entity.Category;
import com.erste.acme.commons.domain.entity.Delivery;
import com.erste.acme.commons.domain.entity.Product;
import com.erste.acme.commons.http.dto.CategoryDto;
import com.erste.acme.commons.http.dto.DeliveryDto;
import com.erste.acme.commons.http.dto.ProductDto;
import java.util.Optional;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ERROR)
public interface ApiDtoMapper {

    DeliveryDto toDeliveryDto(Delivery delivery);

    ProductDto toProductDto(Product product);

    CategoryDto toCategoryDto(Category category);

    default <T> T unwrapOptional(Optional<T> optional) {
        return optional.orElse(null);
    }
}
