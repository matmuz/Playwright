package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SampleTests extends BaseTest {

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
        assertEquals(8, landingPage.getProducts().size(),
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
}