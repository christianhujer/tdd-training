package com.nelkinda.training.tdd;

import org.junit.*;

public class JUnitExampleTest {

    static {
        System.err.println("1. Static Initializer");
    }

    {
        System.err.println("3. / 8. Initializer");
    }

    public JUnitExampleTest() {
        System.err.println("4. / 9. Constructor");
    }

    @BeforeClass
    public static void beforeClass1() {
        System.err.println("2. @BeforeClass beforeClass1()");
    }

    @BeforeClass
    public static void beforeClass2() {
        System.err.println("2. @BeforeClass beforeClass2()");
    }

    @Before
    public void before1() {
        System.err.println("5. / 10. @Before before1()");
    }

    @Before
    public void before2() {
        System.err.println("5. / 10. @Before before2()");
    }

    @Test
    public void test1() {
        System.err.println("6. @Test test1()");
    }

    @After
    public void after1() {
        System.err.println("7. / 12. @After after1()");
    }

    @After
    public void after2() {
        System.err.println("7. / 12. @After after2()");
    }

    @Test
    public void test2() {
        System.err.println("11. @Test test2()");
    }

    @Ignore
    @Test
    public void test3() {
        System.err.println("Not run.");
    }

    @AfterClass
    public static void afterClass1() {
        System.err.println("13. @AfterClass1()");
    }

    @AfterClass
    public static void afterClass2() {
        System.err.println("13. @AfterClass2()");
    }
}
