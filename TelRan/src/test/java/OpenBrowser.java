import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenBrowser {
WebDriver wd;

@BeforeClass
    public void setUp (){
    wd=new ChromeDriver();
    }

@Test
public void chromeBrowserTest(){
    wd.get("https://www.google.ru/");
}

@AfterClass
    public void tearDown() throws InterruptedException {
    Thread.sleep(2000);
    wd.quit();
}
}

