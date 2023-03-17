package org.example.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderModel {

    private final List<ProductModel> listOfProducts;

    public OrderModel() {
        this.listOfProducts = new ArrayList<>();
    }

    public int getItemsQuantity() {
        return listOfProducts.stream().mapToInt(ProductModel::getQuantity).sum();
    }

    public double getItemsPrice() {
        return Math.round(listOfProducts.stream()
                                        .mapToDouble(product -> product.getPrice() * product.getQuantity())
                                        .sum() * 100.0) / 100.0;
    }

    public double getTotalPrice(boolean isLoggedIn) {
        return getItemsPrice() + getShippingCost(isLoggedIn);
    }

    private double getShippingCost(boolean isLoggedIn) {
        if (isLoggedIn) {
            return 0.00;
        }
        return 7.00;
    }
}
