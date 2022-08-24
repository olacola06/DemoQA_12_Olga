package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd){
        this.wd = wd;
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }
    public void type(By locator, String message){
        WebElement e =wd.findElement(locator);
        e.click();
        e.clear();
        e.sendKeys(message);
    }
    public void selectValue(By locator, String option){
        new Select(wd.findElement(locator)).selectByValue(option);

    }
    public void selectText(By locator, String option){
        new Select(wd.findElement(locator)).selectByVisibleText(option);
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

    public void makeScreenShot(String link) {
        File shot =((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);

        try{
            Files.copy(shot,new File(link));
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void switchWindows(){
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1)).close();
        wd.switchTo().window(tabs.get(0));
    }

    public void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('footer').style.display='none'");

    }
}
