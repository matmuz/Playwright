package org.example.pages.products;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LandingPage extends BaseProductsPage {

    private final Locator carouselItem;

    public LandingPage(Page page) {
        super(page);
        this.carouselItem = page.locator("#carousel li.carousel-item.active");
    }

    public boolean isCarouselDisplayed() {
        return carouselItem.isVisible();
    }
}