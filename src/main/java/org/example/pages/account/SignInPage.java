package org.example.pages.account;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.pages.account.common.AccountBasePage;

public class SignInPage extends AccountBasePage {

    private final Page page;
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator signInButton;

    public SignInPage(Page page) {
        super(page);
        this.page = page;
        this.emailInput = page.locator("#login-form input[type='email']");
        this.passwordInput = page.locator("#login-form input[type='password']");
        this.signInButton = page.locator("#submit-login");
    }

    public YourAccountPage signIn(String email, String password) {
        emailInput.fill(email);
        passwordInput.fill(password);
        signInButton.click();
        return new YourAccountPage(page);
    }
}
