package org.example.tests;

import org.example.base.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTests extends BaseTest {

    @ParameterizedTest(name = "shouldFindProductsWithText-{0}")
    @ValueSource(strings = {"HUMMINGBIRD", "POSTER"})
    public void shouldFindProductsWithText(String textToSearch) {
        landingPage.getTopMenuPage()
                   .typeTextToSearchInput(textToSearch)
                   .clickOnSearchIcon()
                   .getProductsNames()
                   .forEach(name -> assertTrue(name.contains(textToSearch),
                                               "Found product does not contain expected text"));
    }

    @ParameterizedTest(name = "shouldOpenFoundProduct-{0}")
    @ValueSource(strings = {"HUMMINGBIRD SWEATER", "TODAY POSTER"})
    public void shouldOpenFoundProduct(String productToOpen) {
        assertEquals(productToOpen, landingPage.getTopMenuPage()
                                               .typeTextToSearchInput(productToOpen)
                                               .clickOnSearchIcon()
                                               .selectProductByName(productToOpen)
                                               .getProductName(), "Opened product's name is not equal to expected");
    }
}
