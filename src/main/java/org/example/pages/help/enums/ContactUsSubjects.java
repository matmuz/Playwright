package org.example.pages.help.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContactUsSubjects {

    CUSTOMER_SERVICE("Customer service"),
    WEBMASTER("Webmaster");

    private final String value;
}
