package org.example.pages.products;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import org.example.pages.common.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseProductsPage extends BasePage {

    private final Page page;
    private final List<ElementHandle> products;

    public BaseProductsPage(Page page) {
        super(page);
        this.page = page;
        this.products = page.querySelectorAll(".thumbnail-container");
    }

    public int getNumberOfProducts() {
        return products.size();
    }

    public ProductPage selectRandomProduct() {
        getHelper().getRandomElementFromList(products).click();
        return new ProductPage(page);
    }

    public ProductPage selectProductByName(String productName) {
        products.stream()
                .filter(product -> product.innerText().contains(productName))
                .collect(Collectors.toList())
                .get(0)
                .click();
        return new ProductPage(page);
    }
}
