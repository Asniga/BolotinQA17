import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class OpenBrowser {
WebDriver wd;

@BeforeClass
    public void setUp (){
    wd=new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); // wait max 3 sec dlya poiska elementov, idet dal'she
    }

@Test
public void chromeBrowserTest(){
    OpenSite();
    Type();
    ClickSerchButton();
}

@Test
public void TesrEBayFilter(){
    OpenSite();
    Type();
    ClickSerchButton();
    filterByAuction();

}

    public void filterByAuction() {
        wd.findElement(By.linkText("Auction")).click();
    }


    public void ClickSerchButton() {
        wd.findElement(By.id("gh-btn")).click();
    }

    public void Type() {
        wd.findElement(By.id("gh-ac")).click();
        wd.findElement(By.id("gh-ac")).clear();
        wd.findElement(By.id("gh-ac")).sendKeys("glasses");
    }

    public void OpenSite() {
        wd.get("https://www.ebay.com/");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
    Thread.sleep(2000);
    wd.quit();
}
}

