package com.nelkinda.training.tdd;

import com.nelkinda.training.tdd.Factorial;
import org.junit.Test;

import static com.nelkinda.training.tdd.Factorial.factorial;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {

    // TODO Make JUnit find this test.
    public void testFactorial() {
        assertThat(factorial(0), is(1));
        assertThat(factorial(1), is(1));
        // TODO Add more test cases:
        // - Test that the factorial of 2 is 2
        // - Test that the factorial of 3 is 6.
    }
}
