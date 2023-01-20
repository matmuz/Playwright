package org.example.tests;

import org.example.base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTests extends BaseTest {

    @Test
    public void shouldFindProductsWithText() {
        String textToSearch = "HUMMINGBIRD";
        landingPage.getTopMenuPage()
                   .typeTextToSearchInput(textToSearch)
                   .clickOnSearchIcon()
                   .getFoundProductsNames()
                   .forEach(name -> assertTrue(name.contains(textToSearch),
                                               "Found product does not contain expected text"));
    }

    @Test
    public void shouldOpenFoundProduct() {
        String productToFind = "HUMMINGBIRD SWEATER";
        assertEquals(productToFind, landingPage.getTopMenuPage()
                                               .typeTextToSearchInput(productToFind)
                                               .clickOnSearchIcon()
                                               .clickOnSelectedResult(productToFind)
                                               .getProductName(),
                     "Opened product's name is not equal to expected");
    }
}
