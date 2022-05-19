package itse1909r.borangaziyev.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BuildingTest {
    Building building = new Building();

    @Test
    void testSetBuildingId() {
        building.setBuildingId(0);
    }

    @Test
    void testSetAddress() {
        building.setAddress("address");
    }

    @Test
    void testSetUserId() {
        building.setUserId(0);
    }

    @Test
    void testEquals() {
        boolean result = building.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = building.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = building.hashCode();
        Assertions.assertNotNull(result);
    }

    @Test
    void testToString() {
        String result = building.toString();
        Assertions.assertEquals("Building(buildingId=0, address=null, userId=0)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme