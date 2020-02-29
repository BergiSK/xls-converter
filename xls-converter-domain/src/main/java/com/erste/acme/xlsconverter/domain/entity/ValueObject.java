package com.erste.acme.xlsconverter.domain.entity;

import org.immutables.value.Value;

@Value.Style(
    visibility = Value.Style.ImplementationVisibility.PACKAGE,
    builderVisibility = Value.Style.BuilderVisibility.PUBLIC,
    typeImmutable = "Imm*",
    builder = "new",
    jdkOnly = true
)
public @interface ValueObject {

}
