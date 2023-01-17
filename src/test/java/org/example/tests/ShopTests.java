package org.example.tests;

import org.example.base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopTests extends BaseTest {

    @Test
    public void shouldDisplayShopLogo() {
        assertTrue(landingPage.getTopMenuPage().getShopLogo().isVisible(),
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
        assertEquals(expectedProducts, landingPage.getProducts().size(),
                     "The number of displayed popular products is not equal to expected");
    }

    @Test
    public void shouldDisplayCorrectUsernameAfterSignIn() {
        assertEquals(user.getFullName(), landingPage.getTopMenuPage()
                                                    .goToSignInSection()
                                                    .signIn(user.getEmail(), user.getPassword())
                                                    .getTopMenuPage()
                                                    .getLoggedInAccount(),
                     "Logged in user label text is different than expected");
    }

    @Test
    public void shouldNotDisplayUsernameAfterSignOut() {
        assertFalse(landingPage.getTopMenuPage()
                               .goToSignInSection()
                               .signIn(user.getEmail(), user.getPassword())
                               .getTopMenuPage()
                               .signOut()
                               .isUsernameVisible(),
                    "Logged in username is displayed, but should not be");
    }

    @Test
    public void shouldDisplayCorrectPageHeader() {
        String expectedPageHeader = "Your personal information";
        assertEquals(expectedPageHeader, landingPage.getTopMenuPage()
                                                    .goToSignInSection()
                                                    .signIn(user.getEmail(), user.getPassword())
                                                    .openInformationPage()
                                                    .getPageHeader(),
                     "Displayed page header is not equal to expected");
    }

    @Test
    public void shouldOpenSpecificProduct() {
        String product = "HUMMINGBIRD T-SHIRT";
        assertEquals(product, landingPage.selectPopularProductByName(product).getProductName(),
                     "Selected product's name is not equal to expected");
    }

    @Test
    public void shouldCheckSavedAddress() {
        assertEquals(user.getMyAddress(), landingPage.getTopMenuPage()
                                                     .goToSignInSection()
                                                     .signIn(user.getEmail(), user.getPassword())
                                                     .openAddressPage()
                                                     .getAddressBody(),
                     "Displayed user address is different than expected");
    }
}