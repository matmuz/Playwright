package org.example.tests;

import org.example.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class BasicTests extends BaseTest {

    @ParameterizedTest(name = "shouldOpenSpecificProduct-{0}")
    @ValueSource(strings = {"HUMMINGBIRD T-SHIRT", "THE BEST IS YET POSTER"})
    public void shouldOpenSpecificProduct(String popularProduct) {
        assertEquals(popularProduct, landingPage.selectProductByName(popularProduct).getProductName(),
                     "Selected product's name is not equal to expected");
    }

    @Test
    public void shouldOpenRandomProduct() {
        assertFalse(landingPage.selectRandomProduct().getProductName().isEmpty(),
                    "Opened product name is empty, but should not be");
    }

    @Test
    public void shouldDisplayShopLogo() {
        assertTrue(landingPage.getTopMenuPage().isShopLogoVisible(), "Shop logo is not visible");
    }

    @Test
    public void shouldDisplayFooterSection() {
        assertTrue(landingPage.getFooterPage().isFooterSectionVisible(), "Footer section is not visible");
    }

    @ParameterizedTest(name = "shouldDisplayCorrectNumberOfPopularProducts-{0}")
    @ValueSource(ints = 8)
    public void shouldDisplayCorrectNumberOfPopularProducts(int expectedNumberOfProducts) {
        assertEquals(expectedNumberOfProducts, landingPage.getNumberOfProducts(),
                     "The number of displayed popular products is not equal to expected");
    }

    @Test
    public void shouldDisplayCarousel() {
        assertTrue(landingPage.isCarouselDisplayed(), "Carousel is not displayed");
    }
}
