package com.ait.phonebook.fw;

import com.ait.phonebook.fw.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends HelperBase {
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent() {
        return driver.findElements(By.xpath("//h1[contains(.,'Home Component')]")).size() > 0;
    }
}
