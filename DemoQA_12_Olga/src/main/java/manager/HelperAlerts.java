package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperAlerts extends HelperBase{

    public HelperAlerts(WebDriver wd) {
        super(wd);
    }

    public void alertButton1() {
        click(By.id("alertButton"));
        pause(2000);
        wd.switchTo().alert().accept();
    }

    public void alertButton2() {
        click(By.id("timerAlertButton"));
        new WebDriverWait(wd,6000).until(ExpectedConditions.alertIsPresent());
        wd.switchTo().alert().accept();
    }
    public void alertButton3() {
        click(By.id("confirmButton"));
        pause(2000);
        wd.switchTo().alert().dismiss();
    }
    public void alertButton4() {
        click(By.id("promtButton"));
        Alert alert = wd.switchTo().alert();
        alert.sendKeys("My name is Bob");
        pause(2000);
        String message = alert.getText();
        System.out.println(message);
        alert.accept();
    }

}
