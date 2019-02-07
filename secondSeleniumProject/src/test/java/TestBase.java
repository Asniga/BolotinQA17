import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static AppManager appManager = new AppManager();

    @BeforeSuite
    public void setUp(){
        appManager.start();
    }

    @AfterSuite
    public void tearDown() {
        appManager.stop();
    }
}