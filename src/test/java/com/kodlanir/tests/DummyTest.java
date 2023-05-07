package com.kodlanir.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// https://testng.org/doc/documentation-main.html

public class DummyTest {

    @BeforeMethod(onlyForGroups = "group1")
    public void beforeMethod1() {
        System.out.println("beforeMethod1 is executed");
    }

    @BeforeMethod(onlyForGroups = "group2")
    public void beforeMethod2() {
        System.out.println("beforeMethod2 is executed");
    }

    @Test(groups = "group1")
    public void test1() {
        System.out.println("test1 is executed");
    }

    @Test(groups = "group2")
    public void test2() {
        System.out.println("test2 is executed");
    }
}
