package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Getter
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Map<String, String> myAddress;

    private static final String USER_FILE_PATH = "src/main/resources/user.json";
    private static User user;

    public static User getUser() throws IOException {
        if (user == null) {
            user = new ObjectMapper().readValue(new File(USER_FILE_PATH), User.class);
        }
        return user;
    }

    public String getFullName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }

    public List<String> getAddressDetailsAsList() {
        return List.of(getAddressDetails("address"),
                       getAddressDetails("postalCode"),
                       getAddressDetails("city"));
    }

    private String getAddressDetails(String detailToGet) {
        return myAddress.get(detailToGet);
    }
}