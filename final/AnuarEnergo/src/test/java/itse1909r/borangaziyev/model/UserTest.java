package itse1909r.borangaziyev.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {
    User user = new User();

    @Test
    void testSetUserId() {
        user.setUserId(0);
    }

    @Test
    void testSetFirstName() {
        user.setFirstName("firstName");
    }

    @Test
    void testSetLastName() {
        user.setLastName("lastName");
    }

    @Test
    void testSetUsername() {
        user.setUsername("username");
    }

    @Test
    void testSetPassword() {
        user.setPassword("password");
    }

    @Test
    void testEquals() {
        boolean result = user.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = user.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = user.hashCode();
        Assertions.assertNotNull(result);
    }

    @Test
    void testToString() {
        String result = user.toString();
        Assertions.assertEquals("User(userId=0, firstName=null, lastName=null, username=null, password=null)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme