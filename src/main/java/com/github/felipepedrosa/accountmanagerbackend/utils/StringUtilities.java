package com.github.felipepedrosa.accountmanagerbackend.utils;

/**
 * Utility class for strings.
 */
public class StringUtilities {
    private StringUtilities() {
    }

    /**
     * Check if content is null or empty.
     *
     * @param content Content to be checked.
     * @return {@code Boolean.TRUE} if content is null or empty, otherwise {@code Boolean.FALSE}.
     */
    public static boolean isNullOrEmpty(String content) {
        return content == null || content.isBlank();
    }
}
