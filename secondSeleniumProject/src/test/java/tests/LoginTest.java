package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @BeforeMethod
    public  void  ensurePreconditions() {
        if(TestBase.appManager.isUserLoggedIn()){           // proverka esli user ne zaloginen
            TestBase.appManager.logout();                    // to zaloginetsya
        }
    }
    @Test
    public  void testLogIn() throws InterruptedException {
        TestBase.appManager.clickOnLoginButton();
        TestBase.appManager.fillLoginForm("elena.telran@yahoo.com", "12345.com");
        TestBase.appManager.confirmLogin();
    }
}