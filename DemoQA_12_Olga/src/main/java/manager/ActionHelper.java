package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ActionHelper extends HelperBase {
    public ActionHelper(WebDriver driver){
        super(driver);
    }
    public void chooseElements() {
        click(By.xpath("//h5[.='Elements']"));
    }

    public void chooseButtons() {
        click(By.xpath("//span[.='Buttons']"));
    }

    public void doubleClickMe() {
        Actions action = new Actions(wd);
        WebElement el = wd.findElement(By.id("doubleClickBtn"));
        action.doubleClick(el).perform();

    }

    public boolean isDoubleClickDone() {
        return wd.findElement(By.id("doubleClickMessage")).getText().equals("You have done a double click");
    }

    public void rightClick() {
        WebElement rightClick = wd.findElement(By.id("rightClickBtn"));
        new Actions(wd).contextClick(rightClick).perform();
    }

    public boolean isRightClickDone() {
        return wd.findElement(By.id("rightClickMessage")).getText().equals("You have done a right click");
    }
}

