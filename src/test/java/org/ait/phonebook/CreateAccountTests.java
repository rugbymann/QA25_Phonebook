package org.ait.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateAccountTests extends TestBase{

    //precondition: if user should be logged out


    @BeforeMethod
    public void ensurePrecondition(){
        if(!isElementPresent(By.cssSelector("a:nth-child(4)"))){
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        }

        //click on Login link  CSS - a:nth-child(4)
        driver.findElement(By.cssSelector("a:nth-child(4)")).click();


    }
    @Test
    public void newUserRegistrationPositiveTest(){
        // enter email  CSS - [placeholder='Email']
        driver.findElement(By.cssSelector("[placeholder='Email']")).click();
        driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("orxan@mail.ru");

        //enter password   CSS - [placeholder='Password']
        driver.findElement(By.cssSelector("[placeholder='Password']")).click();
        driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Orxan123$");

        //click on Registration button  Xpath - //button[(text(),'Registration')]
        driver.findElement(By.xpath("//button[text()='Registration']")).click();
        //driver.findElement(By.xpath("//button[(text(),'Registration')]")).clear();
        //assert Sign out button displayed   Xpath - //button[contains(.,'Sign Out')]
        Assert.assertTrue(isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]")));

    }


}
