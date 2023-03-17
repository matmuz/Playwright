package org.example.pages.help;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import org.example.pages.base.BasePage;
import org.example.pages.help.enums.ContactUsSubjects;

import java.nio.file.Path;

public class ContactUsPage extends BasePage {

    private final Page page;
    private final Locator header;
    private final Locator subjectSelector;
    private final Locator emailInput;
    private final Locator messageInput;
    private final Locator sendButton;
    private final Locator successLabel;
    private final String uploadFileButtonLocator;

    public ContactUsPage(Page page) {
        super(page);
        this.page = page;
        this.header = page.locator("#main h3");
        this.subjectSelector = page.locator("#main select");
        this.emailInput = page.locator("#main input[type='email']");
        this.messageInput = page.locator("textarea");
        this.sendButton = page.locator("input[value='Send']");
        this.successLabel = page.locator(".alert-success");
        this.uploadFileButtonLocator = ".buttonText";
    }

    public boolean isSuccessMessageDisplayed() {
        return successLabel.isVisible();
    }

    public String getHeader() {
        return header.innerText();
    }

    public ContactUsPage selectSubject(ContactUsSubjects subject) {
        subjectSelector.selectOption(new SelectOption().setLabel(subject.getValue()));
        return this;
    }

    public ContactUsPage typeEmail(String email) {
        emailInput.type(email);
        return this;
    }

    public ContactUsPage uploadFile(String filePath) {
        page.setInputFiles(uploadFileButtonLocator, Path.of(filePath));
        return this;
    }

    public ContactUsPage typeMessage(String message) {
        messageInput.type(message);
        return this;
    }

    public ContactUsPage clickSendButton() {
        sendButton.click();
        return this;
    }

    public ContactUsPage composeHelpMessage(ContactUsSubjects subject, String email, String filePath, String message,
                                            boolean clickSendButton) {
        selectSubject(subject).typeEmail(email).uploadFile(filePath).typeMessage(message);
        if (clickSendButton) {
            clickSendButton();
        }
        return this;
    }
}