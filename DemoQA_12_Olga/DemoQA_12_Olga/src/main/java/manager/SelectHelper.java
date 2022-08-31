package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SelectHelper extends HelperBase{

    public SelectHelper(WebDriver driver){
        super(driver);
    }

    public void selectWidget() {
        click(By.xpath("//h5[.='Widgets']"));
    }

    public void selectSelectMenu() {
        click(By.xpath("//li[.='Select Menu']"));
    }

    public void firstSelect(String option) {
        click(By.cssSelector("div[id='selectMenuContainer'] div.row:nth-child(2) div.css-1wy0on6"));
        String locator = String.format("//*[.='$s']",option);
        click(By.xpath(locator));
        Assert.assertTrue(wd.findElement(By.cssSelector(". css-1uccc91-singleValue")).getText().contains(option));
    }
}
