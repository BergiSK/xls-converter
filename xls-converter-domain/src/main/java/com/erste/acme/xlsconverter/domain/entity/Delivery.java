package com.erste.acme.xlsconverter.domain.entity;

import java.util.Date;

@ValueObject
public interface Delivery {

    Date getDate();

    Product getProduct();

    long getAmount();

    static Delivery.Builder builder() {
        return new Delivery.Builder();
    }

    class Builder extends ImmDelivery.Builder {
    }
}
