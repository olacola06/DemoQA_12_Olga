package manager;

import org.openqa.selenium.By;
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

}
