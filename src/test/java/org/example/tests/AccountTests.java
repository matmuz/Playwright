package org.example.tests;

import org.example.base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AccountTests extends BaseTest {

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
    public void shouldCheckSavedAddress() {
        assertEquals(user.getMyAddress(), landingPage.getTopMenuPage()
                                                     .goToSignInSection()
                                                     .signIn(user.getEmail(), user.getPassword())
                                                     .openAddressPage()
                                                     .getAddressBody(),
                     "Displayed user address is different than expected");
    }
}
