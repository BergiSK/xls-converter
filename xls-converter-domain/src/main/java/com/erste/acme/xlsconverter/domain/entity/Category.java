package com.erste.acme.xlsconverter.domain.entity;

import java.util.Optional;

@ValueObject
public interface Category {

    Optional<Integer> getLimitBottom();

    Optional<Integer> getLimitTop();

    Optional<Double> getFee();

    String getName();

    static Category.Builder builder() {
        return new Category.Builder();
    }

    class Builder extends ImmCategory.Builder {
    }
}
