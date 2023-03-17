package org.example.tests;

import org.example.base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.example.pages.account.enums.AccountSections.INFORMATION;
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
                               .isUsernameVisible(), "Logged in username is displayed, but should not be");
    }

    @Test
    public void shouldDisplayCorrectInformationPageHeader() {
        assertEquals(INFORMATION.getHeader(), landingPage.getTopMenuPage()
                                                         .goToSignInSection()
                                                         .signIn(user.getEmail(), user.getPassword())
                                                         .openInformationPage()
                                                         .getPageHeader(),
                     "Displayed page header is not equal to expected");
    }

    @Test
    public void shouldCheckSavedAddress() {
        assertEquals(user.getAddressDetailsAsList(), landingPage.getTopMenuPage()
                                                                .goToSignInSection()
                                                                .signIn(user.getEmail(), user.getPassword())
                                                                .openAddressPage()
                                                                .getAddressDetailsAsList(),
                     "Displayed user address is different than expected");
    }
}
