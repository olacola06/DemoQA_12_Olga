package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Interactions extends HelperBase{

    public Interactions (WebDriver driver){
        super(driver);
    }

    public void chooseSortable() {
        click(By.xpath("//span[.='Sortable']"));
    }
    public void sortList(String string) {
        String[] listOfNum = string.split(",");
        List<WebElement> list = new ArrayList<>();
            for(int i=0; i<6;i++) {
                String locator = String.format("//div[.='%s']",listOfNum[i]);
                WebElement el = wd.findElement(By.xpath(locator));
                list.add(el);
            }
        System.out.println("Total numbers in the list = "+list.size());
            Actions action = new Actions(wd);
            //action.dragAndDrop(list.get(0), list.get(4)).perform();
            for(int i=0;i<list.size()-2;i++){
                action.dragAndDrop(list.get(i),list.get(i+2)).perform();
            }
    }

    public void chooseSelectable() {
        click(By.xpath("//span[.='Selectable']"));
    }

    public void selectableGrid(String string) {
        click(By.id("demo-tab-grid"));
        String[] list = string.split(",");
        for (int i = 0; i < list.length; i++) {
            String locator = String.format("//li[.='%s']", list[i]);
            wd.findElement(By.xpath(locator)).click();
        }
        List<WebElement> selectedNums = wd.findElements(By.
                cssSelector("li[class='list-group-item active list-group-item-action']"));
        Assert.assertEquals(selectedNums.size(),list.length);
    }

    public void chooseResizable() {
        click(By.xpath("//span[.='Resizable']"));
    }

    public void resizableBox() {
        pause(2000);
        WebElement spanDrag = wd.findElement(By.cssSelector
                ("#resizableBoxWithRestriction span[class='react-resizable-handle react-resizable-handle-se']"));
        Rectangle rect = wd.findElement(By.id("resizableBoxWithRestriction")).getRect();
        System.out.println("X = "+rect.getX()+", Y = "+rect.getY());
        Actions action = new Actions(wd);
        int xOffSetMax = rect.getWidth()+100; //offSet means difference between rect width and height And length where to move rect
        int yOffSetMax = rect.getHeight()-100;//in this case rect width 200 will be moved on 200+100 = 300, total 500 if to count from getX()
        //action.dragAndDropBy(spanDrag,xOffSetMax,yOffSetMax).perform();
        int xOffSetMin = rect.getWidth()-250;
        int yOffSetMin = rect.getHeight()-250;
        action.clickAndHold(spanDrag).moveByOffset(xOffSetMin,yOffSetMin).perform();
        Assert.assertEquals(wd.findElement(By.id("resizableBoxWithRestriction")).getRect().getWidth(),150);

    }
}
