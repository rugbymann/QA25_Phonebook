package org.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void isHomeComponentPresentTest(){
        driver.findElements(By.xpath("//h1[text()='Home Component']"));

        Assert.assertTrue(isHomeComponentPresent());

    }

}
