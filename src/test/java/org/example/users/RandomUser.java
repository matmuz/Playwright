package org.example.users;

import lombok.Getter;
import org.example.helpers.CommonHelper;

@Getter
public class RandomUser {

    private String firstName;
    private String lastName;
    private String email;

    private RandomUser() {
    }

    public static final class Builder {
        private String firstName;
        private String lastName;
        private String email;

        public Builder firstName() {
            this.firstName = CommonHelper.faker.name().firstName();
            return this;
        }

        public Builder lastName() {
            this.firstName = CommonHelper.faker.name().lastName();
            return this;
        }

        public Builder email() {
            this.email = this.firstName + this.lastName + "@gmail.com";
            return this;
        }

        public RandomUser build() {
            RandomUser randomUser = new RandomUser();
            randomUser.firstName = this.firstName;
            randomUser.lastName = this.lastName;
            randomUser.email = this.email;
            return randomUser;
        }
    }
}
