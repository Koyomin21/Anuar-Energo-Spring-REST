package itse1909r.borangaziyev.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BuildingTypeTest {
    BuildingType buildingType = new BuildingType();

    @Test
    void testSetBuildingTypeId() {
        buildingType.setBuildingTypeId(0);
    }

    @Test
    void testSetName() {
        buildingType.setName("name");
    }

    @Test
    void testSetRateId() {
        buildingType.setRateId(0);
    }

    @Test
    void testEquals() {
        boolean result = buildingType.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = buildingType.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = buildingType.hashCode();
        Assertions.assertNotNull(result);
    }

    @Test
    void testToString() {
        String result = buildingType.toString();
        Assertions.assertEquals("BuildingType(buildingTypeId=0, name=null, rateId=0)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme