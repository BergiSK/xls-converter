package com.erste.acme.xlsconverter.domain.entity;

import java.util.Optional;

@ValueObject
public interface Product {

    Optional<Category> getCategory();

    String getName();

    static Product.Builder builder() {
        return new Product.Builder();
    }

    class Builder extends ImmProduct.Builder {
    }

}
