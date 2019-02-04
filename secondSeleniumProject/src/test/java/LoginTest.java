import org.testng.annotations.Test;

public class LoginTest extends  TestBase {

    @Test
    public  void testLogIn() throws InterruptedException {
        clickOnLoginButton();
        fillLoginForm();
        confirmLogin();
    }


}