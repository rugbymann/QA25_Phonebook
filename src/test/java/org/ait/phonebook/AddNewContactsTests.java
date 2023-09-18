package org.ait.phonebook;

import com.ait.phonebook.models.Contact;
import com.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddNewContactsTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            clickOnSignButton();
        }


        app.getUser().clickOnLoginLink();
        app.getUser().login();

        //click on ADD link
        app.getContact().clickOnAddLink();

    }

    @Test
    public void addNewContactPositiveTest() {
        //fill in add contact form  - input:nth-child(1)
        app.getContact().fillContactForm(new Contact().setName("Karl")
                .setSurname("Baba")
                .setPhone("112323123123")
                .setEmail("karl@mail.ru")
                .setAddress("FFM")
                .setDesc("forward"));
        //click on Save button
        app.getContact().clickOnSaveButton();
        //assert new contact added
        Assert.assertTrue(app.getContact().isContactAdded("Karl"));


    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }

    @DataProvider
    public Iterator<Object[]> addNewContact() {

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kan", "12332345234", "kan@gmx.com", "Berlin", "goalkeeper"});
        list.add(new Object[]{"Mesut", "Özil", "12332345224", "mesut@gmx.com", "Berlin", "forward"});
        list.add(new Object[]{"Tony", "Kroos", "11112345234", "tony@gmx.com", "FFM", "forward"});

        return list.iterator();
    }

    @Test(dataProvider = "addNewContact")
    public void addNewContactPositiveFromDataProviderTest(String name, String surname, String phone, String email, String address, String desk) {
        app.getContact().fillContactForm(new Contact().setName(name)
                .setSurname(surname)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDesc(desk));

        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(name));
    }

    @DataProvider
    public Iterator<Object[]> addNewContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));

        String line = reader.readLine();
        while (line != null) {

            String[] split = line.split(",");


            list.add(new Object[]{new Contact().setName(split[0])
                    .setSurname(split[1])
                    .setPhone(split[2])
                    .setEmail(split[3])
                    .setAddress(split[4])
                    .setDesc(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "addNewContactFromCSV")
    public void addNewContactPositiveFromDataProviderWithCSVTest(Contact contact) {
        app.getContact().fillContactForm(contact);

        app.getContact().clickOnSaveButton();
        Assert.assertEquals(Integer.toString(app.getContact().sizeOfContacts()),"1");
    }

}


