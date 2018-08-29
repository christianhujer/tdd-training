package com.nelkinda.training.tdd;

import org.junit.Test;

import static org.junit.Assert.fail;

// Test Class, contains test cases.
// Name pattern *Test so that the Maven Surefire Plugin discovers tests.
public class JUnitExample01Test {

    // Test Annotation used by JUnit to discover tests.
    @Test
    public void test() {
        // Fail this test.
        fail();
    }

    // Another test
    @Test
    public void anotherTest() {
        // Fail this test.
        fail();
    }
}
