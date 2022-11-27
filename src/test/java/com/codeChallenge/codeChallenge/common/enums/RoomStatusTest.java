package com.codeChallenge.codeChallenge.common.enums;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RoomStatusTest {

    @Test
    public void testToString() {
        String dummyString = "Available";
        RoomStatus dummy = RoomStatus.AVAILABLE;
        Assert.assertEquals(dummy.toString(), dummyString, "toString doesn't match");
    }
}
