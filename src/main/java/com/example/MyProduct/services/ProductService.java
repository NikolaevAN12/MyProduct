package com.example.MyProduct.services;

import com.example.MyProduct.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Product(++ID, "PlayStation 5", "Simple description", 67000, true));
        products.add(new Product(++ID, "Iphone 8", "Simple description", 24000, false));
    }

    public List<Product> listProducts() {  /*Получение всего списка*/
        return products;
    }

    public void saveProduct(Product product) {
        product.setId(++ID);
        products.add(product);
    }
    public void updateProduct(Long id,Product product) {
        products.replaceAll(product1 -> product1.getId().equals(id)? product : product1);    }

    public void deleteProduct(Long id) { /*Удалить товар*/
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id))
                return product;
        }
        return null;
    }
}
