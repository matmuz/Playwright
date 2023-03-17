package org.example.pages.account.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountSections {

    INFORMATION("INFORMATION", "Your personal information"),
    ADDRESS("ADDRESS", "Your addresses"),
    HISTORY("ORDER HISTORY AND DETAILS", "Order history"),
    SLIPS("CREDIT SLIPS", "Credit slips"),
    GDPR("GDPR - PERSONAL DATA", "GDPR - Personal data");

    private final String name;
    private final String header;
}
