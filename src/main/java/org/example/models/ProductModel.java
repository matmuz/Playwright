package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductModel {

    private final String name;
    private final double price;
    private final int quantity;
}
