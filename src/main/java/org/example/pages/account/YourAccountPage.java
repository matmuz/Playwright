package org.example.pages.account;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import org.example.pages.account.common.AccountBasePage;
import org.example.pages.account.enums.Sections;

import java.util.List;
import java.util.stream.Collectors;

public class YourAccountPage extends AccountBasePage {

    private final Page page;
    private final List<ElementHandle> sections;

    public YourAccountPage(Page page) {
        super(page);
        this.page = page;
        this.sections = page.querySelectorAll(".link-item");
    }

    public InformationPage openInformationPage() {
        filterForSectionElement(Sections.INFORMATION).click();
        return new InformationPage(page);
    }

    public AddressPage openAddressPage() {
        filterForSectionElement(Sections.ADDRESS).click();
        return new AddressPage(page);
    }

    private ElementHandle filterForSectionElement(Sections filteredSection) {
        List<ElementHandle> sectionElement = sections.stream()
                                                     .filter(section -> section.innerText()
                                                                               .contains(filteredSection.getName()))
                                                     .collect(Collectors.toList());
        if (sectionElement.size() != 1) {
            throw new IllegalStateException("Found more than one section via selected filter");
        }
        return sectionElement.get(0);
    }
}
