import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends  TestBase {
    @BeforeMethod
    public  void  ensurePreconditions() throws InterruptedException {
        if(appManager.isUserLoggedIn()){           // proverka esli user ne zaloginen
            appManager.logout();                    // to zaloginetsya
        }
    }
    @Test
    public  void testLogIn() throws InterruptedException {
        appManager.clickOnLoginButton();
        appManager.fillLoginForm("elena.telran@yahoo.com", "12345.com");
        appManager.confirmLogin();
    }


}