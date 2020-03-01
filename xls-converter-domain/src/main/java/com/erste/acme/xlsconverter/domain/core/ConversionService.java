package com.erste.acme.xlsconverter.domain.core;

import com.erste.acme.commons.domain.entity.Category;
import com.erste.acme.commons.domain.entity.Delivery;
import com.erste.acme.commons.domain.entity.Product;
import java.util.List;
import org.springframework.core.io.Resource;

public interface ConversionService {

    List<Product> getProducts(Resource inputResource);

    List<Category> getCategories(Resource inputResource);

    List<Delivery> getDeliveries(Resource inputResource);
}
