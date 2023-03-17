package org.example.tests;

import org.example.base.BaseTest;
import org.example.models.OrderModel;
import org.example.pages.products.enums.ItemsSections;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTests extends BaseTest {

    private OrderModel order;

    @ParameterizedTest(name = "shouldDisplayCorrectItemsPrice-{0}")
    @ValueSource(ints = {1, 3, 5})
    public void shouldDisplayCorrectItemsPrice(int quantity) {
        order = new OrderModel();
        assertEquals(landingPage.selectRandomProduct()
                                .addProductToCart(order.getListOfProducts(), quantity)
                                .getTopMenuPage()
                                .goToShoppingCart()
                                .getItemsPrice(), order.getItemsPrice(),
                     "Displayed total price is not equal to expected");
    }

    @ParameterizedTest(name = "shouldDisplayCorrectItemsQuantity-{0}")
    @ValueSource(ints = {7, 2, 4})
    public void shouldDisplayCorrectItemsQuantity(int quantity) {
        order = new OrderModel();
        assertEquals(landingPage.selectRandomProduct()
                                .addProductToCart(order.getListOfProducts(), quantity)
                                .getTopMenuPage()
                                .goToShoppingCart()
                                .getItemsQuantity(), order.getItemsQuantity(),
                     "Displayed quantity is not equal to expected");
    }

    @ParameterizedTest(name = "shouldDisplayCorrectTotalPriceWithShipping-{0}-{1}")
    @CsvSource({"3,1", "4,2", "2,5"})
    public void shouldDisplayCorrectTotalPriceWithShipping(int firstProductQuantity, int secondProductQuantity) {
        order = new OrderModel();
        assertEquals(landingPage.selectRandomProduct()
                                .addProductToCart(order.getListOfProducts(), firstProductQuantity)
                                .getTopMenuPage()
                                .goToItemsSection(ItemsSections.MEN)
                                .selectRandomProduct()
                                .addProductToCart(order.getListOfProducts(), secondProductQuantity)
                                .getTopMenuPage()
                                .goToShoppingCart()
                                .getTotalPrice(), order.getTotalPrice(false),
                     "Displayed total price with shipping is not equal to expected");
    }

    @ParameterizedTest(name = "shouldDisplayCorrectTotalPriceWithoutShipping-{0}-{1}")
    @CsvSource({"3,2", "1,3", "5,1"})
    public void shouldDisplayCorrectTotalPriceWithoutShipping(int firstProductQuantity, int secondProductQuantity) {
        order = new OrderModel();
        assertEquals(landingPage.getTopMenuPage()
                                .goToSignInSection()
                                .signIn(user.getEmail(), user.getPassword())
                                .getTopMenuPage()
                                .goToLandingPage()
                                .selectRandomProduct()
                                .addProductToCart(order.getListOfProducts(), firstProductQuantity)
                                .getTopMenuPage()
                                .goToItemsSection(ItemsSections.CLOTHES)
                                .selectRandomProduct()
                                .addProductToCart(order.getListOfProducts(), secondProductQuantity)
                                .getTopMenuPage()
                                .goToShoppingCart()
                                .getTotalPrice(), order.getTotalPrice(true),
                     "Displayed total price without shipping is not equal to expected");
    }
}