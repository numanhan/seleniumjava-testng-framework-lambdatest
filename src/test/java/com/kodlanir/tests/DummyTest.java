package com.kodlanir.tests;

import com.github.javafaker.Faker;
import com.kodlanir.utils.Driver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// https://testng.org/doc/documentation-main.html

public class DummyTest {
@Test
public void testt()
{
    Driver.getDriver().get("https://google.com");
    System.out.println(Driver.getDriver().getPageSource());
}

    // Method- BeforeMethod Connection
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
    // Method- BeforeMethod Connection****************

    // Faker Class ı kullanımı ************
    @Test
    public void fakerKullanimi() {
        // https://github.com/DiUS/java-faker

        Faker faker = new Faker();
        System.out.println(faker.address().country());
        System.out.println(faker.currency().name());

        String randomEmail;

        for (int i = 0; i < 250; i++) {
            randomEmail = faker.address().firstName() + "@" + faker.address().lastName() + ".com";
            System.out.println(randomEmail);
        }
    }


 }
