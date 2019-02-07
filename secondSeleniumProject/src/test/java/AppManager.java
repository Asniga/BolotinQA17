import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {
    private TeamHelper teamHelper;
    WebDriver wd;

    public void start() {
        wd= new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        openSite("https://trello.com");
        teamHelper = new TeamHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    protected void clickOnLoginButton() throws InterruptedException {
        Thread.sleep(3000);
        teamHelper.click(By.className("global-header-section-button"));
    }

    protected void confirmLogin() {
        teamHelper.click(By.cssSelector("#login"));


    }

    protected void fillLoginForm(String userName, String password) {
        wd.findElement(By.cssSelector("input[type=email]")).click();
        wd.findElement(By.cssSelector("input[type=email]")).clear();
        wd.findElement(By.cssSelector("input[type=email]")).sendKeys(userName);

        wd.findElement(By.cssSelector("input[type=password]")).click();
        wd.findElement(By.cssSelector("input[type=password]")).clear();
        wd.findElement(By.cssSelector("input[type=password]")).sendKeys(password);
    }

    public void openSite(String url) {
        wd.get(url);
    }

    public  void login() throws InterruptedException {
        clickOnLoginButton();
        fillLoginForm("elena.telran@yahoo.com", "12345.com");
        confirmLogin();
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector("img.member-avatar"));

    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void clickOnAvatar() {
        teamHelper.click(By.xpath("//span[@class='member']"));
    }

    protected void clickOnLogOutButton() {
        teamHelper.click(By.cssSelector("a.js-logout"));
    }

    public void logout() {
        clickOnAvatar();
        clickOnLogOutButton();
    }

    public TeamHelper getTeamHelper() {
        return teamHelper;
    }
}
