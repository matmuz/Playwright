package org.example.pages.products;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.pages.products.common.ProductsBasePage;

public class ProductsPage extends ProductsBasePage {

    private final Locator header;

    public ProductsPage(Page page) {
        super(page);
        this.header = page.locator("h1");
    }

    public String getPageHeader() {
        return header.innerText();
    }
}
