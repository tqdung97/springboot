package com.example.demostream.db;

import com.example.demostream.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    public static List<Product> products = new ArrayList<>(List.of(
            new Product(1, "Iphone 13 Pro Max", 30_000_000, "Apple", 2),
            new Product(2, "Samsung Galaxy Z Fold3", 41_000_000, "Samsung", 1),
            new Product(3, "IPhone 11", 15_500_000, "Apple", 1),
            new Product(4, "OPPO Find X3 Pro", 19_500_000, "OPPO", 3)
    ));
}
