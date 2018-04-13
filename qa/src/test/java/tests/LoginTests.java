package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.LoginPage;
import static org.testng.Assert.*;

public class LoginTests extends TestBase {

    @Test
    public void loginValid(){
        LoginPage l = new LoginPage(driver);
        assertTrue(l.testLogin("guest", "password"));
    }

    @Test(priority=1)
    public void loginInvalid(){
        LoginPage l = new LoginPage(driver);
        assertFalse(l.testLogin("any", "pass"));
    }
}
