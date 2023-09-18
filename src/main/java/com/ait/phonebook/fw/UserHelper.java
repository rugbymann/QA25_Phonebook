package com.ait.phonebook.fw;

import com.ait.phonebook.fw.HelperBase;
import com.ait.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("a:nth-child(4)"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[text()='Login']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[.='LOGIN']"));
    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//button[text()='Registration']"));
    }

    public void fillLoginRegisterForm(User user) {
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        //enter password - [placeholder='Password'] - css
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]"));

    }

    public void login() {
        fillLoginRegisterForm(new User().setEmail("orxan@mail.ru").setPassword("Orxan123$"));
        clickOnSignOutButton();
    }

}
