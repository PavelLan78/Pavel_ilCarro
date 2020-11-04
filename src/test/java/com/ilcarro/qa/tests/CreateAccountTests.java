package com.ilcarro.qa.tests;

import com.ilcarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    //preconditions: user shoud be logged out




    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.header().isSignUpTabPresentInHeader()) {    //sign up not present
            app.header().clickLogout();
        }
    }

    @Test
    public void testSignUp() throws InterruptedException {
        app.header().clickSignUp();
        app.session().fillRegistrationForm(new User()
                .setfName("AS")
                .setlName("FV")
                .setEmail("aa" + System.currentTimeMillis() + "@bb218.com")
                .setPassword("1Aaaaaaaa"));

        //click submit button
        app.session().submitForm();
        logger.info("Login form present. actual result: " + app.session().isLoginFormPresent() + "expectrd result is: true");

        //check, login form displayed
        Assert.assertTrue(app.session().isLoginFormPresent());

    }

    @Test(dataProvider = "validUser", dataProviderClass = DataProvaiders.class)
    public void testSignUpFromDataProvaider(String fName, String lName, String email, String password) throws InterruptedException {
        app.header().clickSignUp();
        app.session().fillRegistrationForm(new User()
                .setfName(fName)
                .setlName(lName)
                .setEmail(email)
                .setPassword(password));

        //click submit button
        app.session().submitForm();
        logger.info("Login form present. actual result: " + app.session().isLoginFormPresent() +":" +  " expectrd result is: true");

        //check, login form displayed
        Assert.assertTrue(app.session().isLoginFormPresent());
    }

    @Test(dataProvider = "validUserFromCSV", dataProviderClass = DataProvaiders.class)
    public void testSignUpFromCSVDataProvaider(User user) throws InterruptedException {
        app.header().clickSignUp();
        app.session().fillRegistrationForm(user);

        //click submit button
        app.session().submitForm();
        logger.info("Login form present. actual result: " + app.session().isLoginFormPresent() +":" + " expectrd result is: true");

        //check, login form displayed
        Assert.assertTrue(app.session().isLoginFormPresent());
    }


}



