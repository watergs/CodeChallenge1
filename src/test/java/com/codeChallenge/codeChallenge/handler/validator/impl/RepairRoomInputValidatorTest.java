package com.codeChallenge.codeChallenge.handler.validator.impl;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RepairRoomInputValidatorTest {

    @InjectMocks
    @Spy
    private CleanRoomInputValidator spy;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testValidateWithNoInput() {
        Assert.assertNull(spy.validate());
    }

    @Test
    public void testValidateWithInput() {
        String room = "1A";
        String actual = spy.validate(room);
        Assert.assertEquals(spy.validate(actual), "Please provide a valid input.",
                "Response doesn't match");
    }
}
