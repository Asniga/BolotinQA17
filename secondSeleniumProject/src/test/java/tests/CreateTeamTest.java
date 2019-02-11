package tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateTeamTest extends TestBase {
    @BeforeMethod
    public  void  ensurePreconditions() throws InterruptedException {
        if(!TestBase.appManager.isUserLoggedIn()){           // proverka esli user ne zaloginen
            TestBase.appManager.login();                    // to zaloginetsya
        }
    }

    @Test
    public void teamCreationFromLeftNavMenu() throws InterruptedException {
       Thread.sleep(3000);
        TestBase.appManager.getTeamHelper().clickOnCreateTeamButtonOnNavMenu();
        TestBase.appManager.getTeamHelper().fillTeamCreationForm();
        TestBase.appManager.getTeamHelper().submitTeamCreation();
        Thread.sleep(1000);
    }


}
