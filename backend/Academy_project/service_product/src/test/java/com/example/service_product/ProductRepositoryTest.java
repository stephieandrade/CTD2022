package com.example.service_product;

import com.example.service_product.entity.Category;
import com.example.service_product.entity.Product;
import com.example.service_product.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;
    @Test
    public void whenfoundbycategory_returnlistproduct(){
        Product product01 = Product.builder() //creamos producto de prueba
                .name("constructor")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1240.99"))
                .status("Created")
                .createdAt(new Date()).build();
        repository.save(product01);

        List<Product> found = repository.findByCategory(product01.getCategory());

        Assertions.assertEquals(2, found.size());
    }
}
