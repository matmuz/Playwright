package org.example.pages.account.enums;

import lombok.Getter;

@Getter
public enum Sections {

    INFORMATION("INFORMATION"),
    ADDRESS("ADDRESS"),
    HISTORY("ORDER HISTORY AND DETAILS"),
    SLIPS("CREDIT SLIPS"),
    GDPR("GDPR - PERSONAL DATA");

    private final String name;

    Sections(String name) {
        this.name = name;
    }
}
