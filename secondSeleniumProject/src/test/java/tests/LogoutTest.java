package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase {
    @BeforeMethod
    public  void  ensurePreconditions() throws InterruptedException {
        if(!TestBase.appManager.isUserLoggedIn()){           // proverka esli user ne zaloginen
            TestBase.appManager.login();                    // to zaloginetsya
        }
    }

    @Test
    public void testLogout() throws InterruptedException {
        Thread.sleep(3000);
        TestBase.appManager.clickOnAvatar();
        TestBase.appManager.clickOnLogOutButton();

        Assert.assertFalse(TestBase.appManager.isUserLoggedIn());
    }

}