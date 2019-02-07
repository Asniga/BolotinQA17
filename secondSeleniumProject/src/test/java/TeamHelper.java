import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper {
    WebDriver wd;

    public TeamHelper(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    public void clickOnCreateTeamButtonOnNavMenu() {
        click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
    }

    public void fillTeamCreationForm() {
        click(By.id("org-display-name"));
        wd.findElement(By.id("org-display-name")).clear();
        wd.findElement(By.id("org-display-name")).sendKeys("MyFirstTeam");
        click(By.id("org-desc"));
        wd.findElement(By.id("org-desc")).clear();
        wd.findElement(By.id("org-desc")).sendKeys("MyFirstDescriptions");
    }

    public void submitTeamCreation() {
        click(By.className("js-save"));
    }
}
