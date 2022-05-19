package itse1909r.borangaziyev.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RoleTest {
    Role role = new Role();

    @Test
    void testSetRoleId() {
        role.setRoleId(0);
    }

    @Test
    void testSetRoleName() {
        role.setRoleName("roleName");
    }

    @Test
    void testEquals() {
        boolean result = role.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = role.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = role.hashCode();
        Assertions.assertNotNull(result);
    }

    @Test
    void testToString() {
        String result = role.toString();
        Assertions.assertEquals("Role(roleId=0, roleName=null)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme