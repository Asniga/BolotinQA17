import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends  TestBase {
    @BeforeMethod
    public  void  ensurePreconditions() throws InterruptedException {
        if(!appManager.isUserLoggedIn()){           // proverka esli user ne zaloginen
            appManager.login();                    // to zaloginetsya
        }
    }

    @Test
    public void testLogout() throws InterruptedException {
        Thread.sleep(3000);
        appManager.clickOnAvatar();
        appManager.clickOnLogOutButton();

        Assert.assertFalse(appManager.isUserLoggedIn());
    }

}