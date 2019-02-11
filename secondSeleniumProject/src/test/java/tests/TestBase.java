package tests;
import manager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public static AppManager appManager = new AppManager(BrowserType.CHROME);   //kakoi browser zapustit'

    @BeforeSuite
    public void setUp(){
        appManager.start();
    }

    @AfterSuite
    public void tearDown() {
        appManager.stop();
    }
}