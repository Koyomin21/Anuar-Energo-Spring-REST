package itse1909r.borangaziyev.converters;

import itse1909r.borangaziyev.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringToUserTest {
    StringToUser stringToUser = new StringToUser();

    @Test
    void testConvert() {
        User result = stringToUser.convert("1,Anuario,pass,Anuar,Bora");
        Assertions.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme