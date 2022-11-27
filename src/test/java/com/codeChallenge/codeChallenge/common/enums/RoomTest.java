package com.codeChallenge.codeChallenge.common.enums;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RoomTest {

    @Test
    public void testGetEnumFromPersistentValue() {
        String dummyString = "4C";
        Room dummy = Room.FourC;
        Room actual = Room.getEnumFromPersistentValue(dummyString);
        Assert.assertEquals(actual, dummy, "Room doesn't match");
    }

    @Test
    public void testGetEnumFromPersistentValueWithNullValue() {
        String dummyString = "4CA";
        Room actual = Room.getEnumFromPersistentValue(dummyString);
        Assert.assertEquals(actual, null, "Actual should be null");
    }

    @Test
    public void testToString() {
        String dummyString = "4C";
        Room dummy = Room.FourC;
        Assert.assertEquals(dummy.toString(), dummyString, "toString doesn't match");
    }
}
