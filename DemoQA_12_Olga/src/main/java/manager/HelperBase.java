package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd){
        this.wd = wd;
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void clickAlertsBtn() {
        click(By.xpath("//*[text()='Alerts, Frame & Windows']/ancestor::div[3]"));

    }

    public void chooseAlerts() {
        click(By.xpath("//*[text()='Alerts']"));
    }
    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
