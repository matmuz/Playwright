package org.example.pages.account;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import org.example.pages.account.common.AccountPage;
import org.example.pages.account.enums.AccountSections;

import java.util.List;

public class YourAccountPage extends AccountPage {

    private final Page page;
    private final List<ElementHandle> sections;

    public YourAccountPage(Page page) {
        super(page);
        this.page = page;
        this.sections = page.querySelectorAll(".link-item");
    }

    public AddressPage openAddressPage() {
        clickOnSection(AccountSections.ADDRESS);
        return new AddressPage(page);
    }

    public InformationPage openInformationPage() {
        clickOnSection(AccountSections.INFORMATION);
        return new InformationPage(page);
    }

    public OrderHistoryPage openOrderHistoryPage() {
        clickOnSection(AccountSections.HISTORY);
        return new OrderHistoryPage(page);
    }

    public CreditSlipsPage openCreditSlipsPage() {
        clickOnSection(AccountSections.SLIPS);
        return new CreditSlipsPage(page);
    }

    public PersonalDataPage openPersonalDataPage() {
        clickOnSection(AccountSections.GDPR);
        return new PersonalDataPage(page);
    }

    private void clickOnSection(AccountSections filteredSection) {
        sections.stream().filter(section -> section.innerText().contains(filteredSection.getName()))
                .collect(getHelper().toSingleton()).click();
    }
}
