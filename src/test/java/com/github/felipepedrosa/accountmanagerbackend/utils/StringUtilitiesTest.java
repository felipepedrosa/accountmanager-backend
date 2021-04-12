package com.github.felipepedrosa.accountmanagerbackend.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link StringUtilities}.
 */
class StringUtilitiesTest {
    private static final String WHITESPACES_STRING = "       ";
    private static final String NORMAL_STRING = "Normal string";
    private static final String NULL_STRING = null;

    @Test
    public void testWhitespaceString() {
        Assertions.assertTrue(StringUtilities.isNullOrEmpty(WHITESPACES_STRING),
                "It should return true to \"empty string\"");
    }

    @Test
    public void testNormalString() {
        Assertions.assertFalse(StringUtilities.isNullOrEmpty(NORMAL_STRING),
                "It should return false to a string with content");
    }

    @Test
    public void testNullString() {
        Assertions.assertTrue(StringUtilities.isNullOrEmpty(NULL_STRING),
                "It should return true to a null string");
    }
}
