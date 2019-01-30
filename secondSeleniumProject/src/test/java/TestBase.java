import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
            public void setUp(){
        wd=new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        openSite("https://trello.com/");
    }

    public void login(){
        EnterButton();
        insertName();
        insertPass();
        loginButton2();
    }

    public void loginButton2() {
        wd.findElement(By.id("login")).click();
    }

    public void insertPass() {
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("12345.com");
    }

    public void insertName() {
        wd.findElement(By.id("user")).click();
        wd.findElement(By.id("user")).clear();
        wd.findElement(By.id("user")).sendKeys("elena.telran@yahoo.com");
    }

    public void EnterButton() {
        wd.findElement(By.className("global-header-section-button")).click();
    }

    public void openSite(String url) {
        wd.get(url);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        wd.quit();
    }

    @BeforeTest
    public void ensurePreconditions(){ // proverka chto user zaloginen pered kajdim testom v etom Classe
    if (!isUserLoggedIn())
        login();
    }

    public boolean isUserLoggedIn() {  // proverka chto user zaloginen pered kajdim testom v etom Classe, vzyali code iz ineta
        return isElementPresent(By.cssSelector("img.member-avatar"));   //esli est' takoi lokator to user zaloginen
    }

    public boolean isElementPresent(By by) {
            try {
                wd.findElement(by);
                return true;
            } catch (NoSuchElementException e) {   // pri oshibke vipadet NoSuchElementException
                return false;
            }
        }
}
