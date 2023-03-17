package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.products.enums.ItemsSections;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductsTests extends BaseTest {

    @ParameterizedTest(name = "shouldOpenItemsSection-{0}")
    @EnumSource(value = ItemsSections.class, names = {"CLOTHES", "MEN", "ART", "HOME_ACCESSORIES"})
    public void shouldOpenItemsSection(ItemsSections itemsSection) {
        assertEquals(itemsSection.getName(),
                     landingPage.getTopMenuPage().goToItemsSection(itemsSection).getPageHeader(),
                     "Displayed products page header is different than expected");
    }
}