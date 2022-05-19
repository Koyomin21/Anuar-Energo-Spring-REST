package itse1909r.borangaziyev.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProviderTest {
    Provider provider = new Provider();

    @Test
    void testSetProviderId() {
        provider.setProviderId(0);
    }

    @Test
    void testSetName() {
        provider.setName("name");
    }

    @Test
    void testSetDescription() {
        provider.setDescription("description");
    }

    @Test
    void testSetContactNumber() {
        provider.setContactNumber("contactNumber");
    }

    @Test
    void testEquals() {
        boolean result = provider.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = provider.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = provider.hashCode();
        Assertions.assertNotNull(result);
    }

    @Test
    void testToString() {
        String result = provider.toString();
        Assertions.assertEquals("Provider(providerId=0, name=null, description=null, contactNumber=null)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme