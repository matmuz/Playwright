package org.example.pages.cart;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.pages.base.BasePage;

public class CartPage extends BasePage {

    private final Locator itemsQuantity;
    private final Locator itemsPrice;
    private final Locator shippingCost;
    private final Locator totalPrice;

    public CartPage(Page page) {
        super(page);
        this.itemsQuantity = page.locator("#cart-subtotal-products span.label");
        this.itemsPrice = page.locator("#cart-subtotal-products span.value");
        this.shippingCost = page.locator("#cart-subtotal-shipping span.value");
        this.totalPrice = page.locator(".cart-summary-line.cart-total span.value");
    }

    public int getItemsQuantity() {
        return Integer.parseInt(itemsQuantity.innerText().split(" ")[0]);
    }

    public double getItemsPrice() {
        return parseAmountToDouble(itemsPrice.innerText());
    }

    public double getShippingCost() {
        if (shippingCost.innerText().equals("Free")) {
            return 0.00;
        }
        return parseAmountToDouble(shippingCost.innerText());
    }

    public double getTotalPrice() {
        return parseAmountToDouble(totalPrice.innerText());
    }

    public double parseAmountToDouble(String textToParse) {
        return Double.parseDouble(textToParse.split("\\$")[1]);
    }
}
