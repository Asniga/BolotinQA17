import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenBrowser {
WebDriver wd;

@BeforeClass
    public void setUp (){
    wd=new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); // jdet max 3 sec dlya poiska elementov, idet dal'she
    }

@Test
public void chromeBrowserTest(){
    wd.get("https://www.google.ru/");
    // type in SearchBar
    wd.findElement(By.name("q")).click();
    wd.findElement(By.name("q")).clear();
    wd.findElement(By.name("q")).sendKeys("Selenium");
    wd.findElement(By.name("btnK")).click();
}

@AfterClass
    public void tearDown() throws InterruptedException {
    Thread.sleep(2000);
    wd.quit();
}
}

