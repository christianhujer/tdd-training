package com.nelkinda.training.tdd;

import org.junit.Test;

import static com.nelkinda.training.tdd.Sum.sum;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

// Typical test: Verify that the actual result matches an expected result.
public class JUnitExample02Test {
    @Test
    public void testSumWithJUnitAssertions() {
        final int expected = 42;
        final int actual = sum(23, 19);

        // Classical JUnit assertion for verification.
        assertEquals(expected, actual);

        // Short:
        assertEquals(42, sum(23, 19));
    }

    @Test
    public void testSumWithHamcrestMatchers() {
        // Hamcrest Matcher (almost) read like well-written prose.
        assertThat(sum(23, 19), is(42));
    }
}
