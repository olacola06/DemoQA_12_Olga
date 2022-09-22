package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Objects;

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
        int xOffSet = rectDrop.getX() - rectDrag.getX();
        new Actions(wd).clickAndHold(dragMe).moveByOffset(xOffSet,0).release().perform();

    }

    public boolean isDragAndDropDone() {
        return wd.findElement(By.xpath("//p[.='Dropped!']")).getText().contains("Dropped!");
    }

    public void refreshPage() {
        wd.navigate().refresh();
    }

    public void dropAcceptable() {
        new WebDriverWait(wd,15).until(ExpectedConditions.visibilityOf(
                wd.findElement(By.xpath("//a[.='Accept']"))));
        click(By.xpath("//a[.='Accept']"));
        WebElement acceptable = wd.findElement(By.id("acceptable"));
        WebElement dropHere = wd.findElement(By.cssSelector("div[id='acceptDropContainer'] div#droppable"));
        new Actions(wd).dragAndDrop(acceptable,dropHere).perform();
        Assert.assertEquals(wd.findElement(By.xpath("//p[.='Dropped!']")).getText(),"Dropped!");
    }

    public void dropNotAcceptable() {
        new WebDriverWait(wd,15).until(ExpectedConditions.visibilityOf(
                wd.findElement(By.xpath("//a[.='Accept']"))));
        click(By.xpath("//a[.='Accept']"));
        WebElement notAcceptable = wd.findElement(By.id("notAcceptable"));
        WebElement dropHere = wd.findElement(By.cssSelector("div[id='acceptDropContainer'] div#droppable"));
        new Actions(wd).clickAndHold(notAcceptable).moveToElement(dropHere).perform();
        Assert.assertFalse(wd.findElement(By.xpath("//p[.='Dropped!']")).getText().contains("Dropped!"));
    }

    public void dropPreventGreedy() {
        new WebDriverWait(wd,15).until(ExpectedConditions.elementToBeClickable(
                wd.findElement(By.xpath("//*[.='Prevent Propogation']")))).click();
        WebElement innerDrop = wd.findElement(By.xpath("//*[.='Inner droppable (greedy)']"));
        WebElement dragMe = wd.findElement(By.id("dragBox"));
        Actions action = new Actions(wd);
        action.dragAndDrop(dragMe,innerDrop).perform();
        Assert.assertTrue(wd.findElements(By.xpath("//*[.='Dropped!']")).size()>0);
    }
    public void willRevert() {
        new WebDriverWait(wd,15).until(ExpectedConditions
                .visibilityOf(wd.findElement(By.xpath("//*[.='Revert Draggable']")))).click();
        WebElement willRevert = wd.findElement(By.id("revertable"));
        Rectangle rect = willRevert.getRect();
        Point start = rect.getPoint();
        System.out.println("Started point of willRevert square is-> "+start.toString());
        WebElement dropHere = wd.findElement(By.cssSelector("div.revertable-drop-container div#droppable"));
        new Actions(wd).dragAndDrop(willRevert,dropHere).perform();
        pause(2000);
        Point finish = rect.getPoint();
        System.out.println("Finished point of willRevert square is-> "+finish.toString());
        Assert.assertEquals(start.getX(),finish.getX());
    }
}

