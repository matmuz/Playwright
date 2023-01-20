package org.example.tests;

import org.example.base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasicTests extends BaseTest {

    @Test
    public void shouldOpenSpecificProduct() {
        String product = "HUMMINGBIRD T-SHIRT";
        assertEquals(product, landingPage.selectProductByName(product).getProductName(),
                     "Selected product's name is not equal to expected");
    }

    @Test
    public void shouldOpenRandomProduct() {
        assertFalse(landingPage.selectRandomProduct().getProductName().isEmpty(),
                    "Opened product name is empty, but should not be");
    }

    @Test
    public void shouldDisplayShopLogo() {
        assertTrue(landingPage.getTopMenuPage().isShopLogoVisible(),
                   "Shop logo is not visible");
    }

    @Test
    public void shouldDisplayFooterSection() {
        assertTrue(landingPage.getFooterPage().getFooterSection().isVisible(),
                   "Footer section is not visible");
    }

    @Test
    public void shouldDisplayCorrectNumberOfPopularProducts() {
        int expectedProducts = 8;
        assertEquals(expectedProducts, landingPage.getNumberOfProducts(),
                     "The number of displayed popular products is not equal to expected");
    }

    @Test
    public void shouldDisplayCarousel() {
        assertTrue(landingPage.isCarouselDisplayed(), "Carousel is not displayed");
    }
}
