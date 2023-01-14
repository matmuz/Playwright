package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Map<String, String> myAddress;
    private static User user;

    public static User getUser() throws IOException {
        if (user == null) {
            user = new ObjectMapper().readValue(new File("src/main/resources/user.json"), User.class);
        }
        return user;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public String getAddress() {
        return myAddress.get("address");
    }

    public String getPostalCode() {
        return myAddress.get("postalCode");
    }

    public String getCity() {
        return myAddress.get("city");
    }
}