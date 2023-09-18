package org.ait.phonebook;

import com.ait.phonebook.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            clickOnSignButton();
        }

        //click on Login link  CSS - a:nth-child(4)
        app.getUser().clickOnLoginLink();


    }
    @Test
    public void loginPositiveTest(){
        app.getUser().login();
        //asser sign out button present
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    } @Test
    public void loginNegativeWithoutPasswordTestTest(){
        app.getUser().fillLoginRegisterForm(new User().setEmail("orxan@mail.ru"));
        //click on Login button - //button[text()='Registration'] - xpath
        app.getUser().clickOnSignOutButton();
        //asser sign out button present
        Assert.assertTrue(app.getUser().isAlertPresent());

    }

}
