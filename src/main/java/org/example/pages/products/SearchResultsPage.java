package org.example.pages.products;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import org.example.pages.common.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends BasePage {

    private final Page page;
    private final List<ElementHandle> products;
    private final String productNameSelector = "h2 a";

    public SearchResultsPage(Page page) {
        super(page);
        this.page = page;
        this.products = page.querySelectorAll(".thumbnail-container");
    }

    public List<String> getFoundProductsNames() {
        List<String> textList = new ArrayList<>();
        products.forEach(product -> textList.add(product.querySelector(productNameSelector).innerText()));
        return textList;
    }

    public ProductPage clickOnSelectedResult(String fullProductName) {
        products.stream()
                .filter(product -> product.querySelector(productNameSelector).innerText().equals(fullProductName))
                .collect(Collectors.toList())
                .get(0)
                .click();
        return new ProductPage(page);
    }
}
