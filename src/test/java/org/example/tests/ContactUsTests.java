package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.help.enums.ContactUsSubjects;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.example.constants.TestConstants.TEST_FILE_PATH;
import static org.example.pages.help.enums.ContactUsSubjects.CUSTOMER_SERVICE;
import static org.example.pages.help.enums.ContactUsSubjects.WEBMASTER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactUsTests extends BaseTest {

    @ParameterizedTest(name = "shouldOpenContactUsPage")
    @ValueSource(strings = "CONTACT US")
    public void shouldOpenContactUsPage(String header) {
        assertEquals(header, landingPage.getTopMenuPage().goToContactUsPage().getHeader(),
                     "Contact Us page header is not equal to expected");
    }

    @ParameterizedTest(name = "shouldSendHelpMessage-{0}-{2}")
    @MethodSource("provideArguments")
    public void shouldSendHelpMessage(String message, String filePath, ContactUsSubjects subject) {
        assertTrue(landingPage.getTopMenuPage()
                              .goToContactUsPage()
                              .composeHelpMessage(subject, randomUser.getEmail(), filePath, message, true)
                              .isSuccessMessageDisplayed(), "Message sent successfully was not displayed");
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(Arguments.of("Lorem", TEST_FILE_PATH, WEBMASTER),
                         Arguments.of("Ipsum", TEST_FILE_PATH, CUSTOMER_SERVICE));
    }
}
