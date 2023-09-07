package org.ait.phonebook;

import com.ait.phonebook.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    //precondition: if user should be logged out


    @BeforeMethod
    public void ensurePrecondition(By clickOnSignButton){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }

        //click on Login link  CSS - a:nth-child(4)
        app.getUser().clickOnLoginLink();


    }

    @Test
    public void createAccountNegativeTest(){
        //enter email - [placeholder='Email'] - css
        app.getUser().fillLoginRegisterForm(new User().setEmail("orxan@mail.ru").setPassword("Orxan123$"));
        //click on Registration button - //button[text()='Registration'] - xpath
        app.getUser().clickOnRegistrationButton();
        //assert Sign out button displayed - //button[contains(.,'Sign Out')] - xpath
        Assert.assertTrue((app.getUser().isAlertPresent()));
    }


}


