package org.example.pages.products;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import lombok.Getter;
import org.example.pages.common.BasePage;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class LandingPage extends BasePage {

    private final Page page;
    private final List<ElementHandle> products;

    public LandingPage(Page page) {
        super(page);
        this.page = page;
        this.products = page.querySelectorAll(".thumbnail-container");
    }

    public ProductPage selectRandomPopularProduct() {
        helper.getRandomElementFromList(products).click();
        return new ProductPage(page);
    }

    public ProductPage selectPopularProductByName(String productName) {
        products.stream()
                .filter(product -> product.innerText().contains(productName))
                .collect(Collectors.toList())
                .get(0)
                .click();
        return new ProductPage(page);
    }
}