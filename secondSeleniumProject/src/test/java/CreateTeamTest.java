import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateTeamTest extends TestBase {
    @BeforeMethod
    public  void  ensurePreconditions() throws InterruptedException {
        if(!appManager.isUserLoggedIn()){           // proverka esli user ne zaloginen
            appManager.login();                    // to zaloginetsya
        }
    }

    @Test
    public void teamCreationFromLeftNavMenu() throws InterruptedException {
       Thread.sleep(3000);
        appManager.getTeamHelper().clickOnCreateTeamButtonOnNavMenu();
        appManager.getTeamHelper().fillTeamCreationForm();
        appManager.getTeamHelper().submitTeamCreation();
        Thread.sleep(1000);
    }


}
