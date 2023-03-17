package org.example.pages.products.common;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import org.example.pages.base.BasePage;
import org.example.pages.products.ProductPage;

import java.util.ArrayList;
import java.util.List;

public abstract class ProductsBasePage extends BasePage {

    private final Page page;
    private final List<ElementHandle> products;

    public ProductsBasePage(Page page) {
        super(page);
        this.page = page;
        page.locator("div.products.row").waitFor();
        this.products = page.querySelectorAll(".thumbnail-container");
    }

    public int getNumberOfProducts() {
        return products.size();
    }

    public List<String> getProductsNames() {
        List<String> textList = new ArrayList<>();
        products.forEach(product -> textList.add(product.querySelector("h2 a").innerText()));
        return textList;
    }

    public ProductPage selectRandomProduct() {
        getHelper().getRandomElementFromList(products).click();
        return new ProductPage(page);
    }

    public ProductPage selectProductByName(String productName) {
        products.stream()
                .filter(product -> product.innerText().contains(productName))
                .collect(getHelper().toSingleton())
                .click();
        return new ProductPage(page);
    }

}
