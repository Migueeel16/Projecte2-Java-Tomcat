package iespoblenou.org.projecte2_fase0.Model;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "PC", 799.99));
        products.add(new Product(2, "Telefono", 499.99));
        products.add(new Product(3, "Pantalla", 149.99));
    }

    public static List<Product> getAllProducts() {
        return products;
    }

}
