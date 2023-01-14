package org.example.pages.products;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.pages.common.BasePage;

public class ProductPage extends BasePage {

    private final Locator productName;

    public ProductPage(Page page) {
        super(page);
        this.productName = page.locator("h1.h1");
    }

    public String getProductName() {
        return productName.innerText();
    }
}
