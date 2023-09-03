package org.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    //precondition: if user should be logged out


    @BeforeMethod
    public void ensurePrecondition(By clickOnSignButton){
        if(!isLoginLinkPresent()){
            clickOnSignOutButton();
        }

        //click on Login link  CSS - a:nth-child(4)
        clickOnLoginLink();


    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        //enter email - [placeholder='Email'] - css
        fillLoginRegistrationForm("orxan@mail.ru", "Orxan123$");
        //click on Registration button - //button[text()='Registration'] - xpath
        clickOnRegistrationButton();
        //assert Sign out button displayed - //button[contains(.,'Sign Out')] - xpath
        Assert.assertTrue((isAlertPresent()));
    }


}


