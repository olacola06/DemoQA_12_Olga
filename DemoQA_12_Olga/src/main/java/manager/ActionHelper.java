package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
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

    public void dynamicClick() {
        WebElement e = wd.findElement(By.xpath("//button[.='Click Me']"));
        //e.click();
        Actions action = new Actions(wd);
        action.moveToElement(e).click().perform();
        Assert.assertTrue(wd.findElement(By.id("dynamicClickMessage")).getText().contains("dynamic click"));
    }

    public void chooseInteractions() {
       click(By.xpath("//h5[.='Interactions']"));
    }

    public void clickDroppable() {
        click(By.xpath("//li[.='Droppable']"));
    }

    public void dragAndDropMe() {
        WebElement dragMe = wd.findElement(By.cssSelector("div[id='draggable']"));
        WebElement dropHere = wd.findElement(By.cssSelector("div#simpleDropContainer div#droppable"));
        Actions action  = new Actions(wd);
        //action.clickAndHold(dragMe).pause(2000).moveToElement(dropHere).release().perform();
        action.dragAndDrop(dragMe,dropHere).perform();

    }
    public void dragAndDropMe2(){
        WebElement dragMe = wd.findElement(By.cssSelector("div[id='draggable']"));
        WebElement dropHere = wd.findElement(By.cssSelector("div#simpleDropContainer div#droppable"));
        Rectangle rectDrag = dragMe.getRect();
        Rectangle rectDrop = dropHere.getRect();
        int xOffSet = rectDrag.getWidth();
        int yOffSet = rectDrag.getHeight()/2;



    }

    public boolean isDragAndDropDone() {
        return wd.findElement(By.xpath("//p[.='Dropped!']")).getText().contains("Dropped!");
    }
}

