package com.tomaszek.carscatalog.utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class TestLogger implements TestWatcher {

    @Override
    public void testSuccessful(ExtensionContext context) {
        String testName = context.getDisplayName();
        System.out.println(testName + " - PASSED");
        System.out.println("──────────────────────────────────────────");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        System.out.println(testName + " - FAILED");
        System.out.println("Reason: " + cause.getMessage());
        System.out.println("──────────────────────────────────────────");
    }
}