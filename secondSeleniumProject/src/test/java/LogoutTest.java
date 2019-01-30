import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase { // osnovivaetsya na TestBase

    @Test
    public void testLogout(){
clickOnAvatar();
clickOnLogOut();
        Assert.assertFalse(isUserLoggedIn()); //proverit' chto LoggedIn=False
    }
    public void clickOnAvatar() {
        wd.findElement(By.cssSelector(".member-avatar")).click();
    }
    public void clickOnLogOut() {
        wd.findElement(By.cssSelector(".js-logout")).click();
    }


}
