package org.example.pages.products;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.models.ProductModel;
import org.example.pages.base.BasePage;

import java.util.List;

public class ProductPage extends BasePage {

    private final Locator productName;
    private final Locator productPrice;
    private final Locator quantityUpButton;
    private final Locator addToCartButton;
    private final Locator continueShoppingButton;

    public ProductPage(Page page) {
        super(page);
        this.productName = page.locator("h1.h1");
        this.productPrice = page.locator("span[itemprop='price']");
        this.quantityUpButton = page.locator(".touchspin-up");
        this.addToCartButton = page.locator(".add-to-cart");
        this.continueShoppingButton = page.locator(".cart-content-btn button[type='button']");
    }

    public String getProductName() {
        return productName.innerText();
    }

    public double getProductPrice() {
        return Double.parseDouble(productPrice.getAttribute("content"));
    }

    public ProductPage addProductToCart(List<ProductModel> listOfProducts, int quantity) {
        increaseQuantityBy(quantity - 1);
        addToCartButton.click();
        continueShoppingButton.click();
        listOfProducts.add(new ProductModel(getProductName(), getProductPrice(), quantity));
        return this;
    }

    private void increaseQuantityBy(int times) {
        quantityUpButton.click(new Locator.ClickOptions().setClickCount(times));
    }
}
