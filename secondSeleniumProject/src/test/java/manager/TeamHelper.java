package manager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper {
    WebDriver wd;

    public TeamHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void clickOnCreateTeamButtonOnNavMenu() {
        click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
    }

    public void fillTeamCreationForm(String text) {
        if(text!=null) {  //esli net nikakogo text to delat' sleduushee
            click(By.id("org-display-name"));
            wd.findElement(By.id("org-display-name")).clear();
            wd.findElement(By.id("org-display-name")).sendKeys("MyFirstTeam");
            click(By.id("org-desc"));
            wd.findElement(By.id("org-desc")).clear();
            wd.findElement(By.id("org-desc")).sendKeys("MyFirstDescriptions");  // mojno napisat' "null"
        }                                                                                // t.e. ne peredavat' nikakoi Description
    }

    public void submitTeamCreation() {
        click(By.className("js-save"));
    }

    public void fillTeamCreationForm() {
    }
}
