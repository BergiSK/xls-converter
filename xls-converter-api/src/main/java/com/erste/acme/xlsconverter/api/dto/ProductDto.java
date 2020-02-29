package com.erste.acme.xlsconverter.api.dto;

public class ProductDto {

    private CategoryDto category;

    private String name;

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
