package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.security.Key;
import java.util.List;

public class SelectHelper extends HelperBase {

    public SelectHelper(WebDriver driver) {
        super(driver);
    }

    public void selectWidget() {
        click(By.xpath("//h5[.='Widgets']"));
    }

    public void selectSelectMenu() {
        click(By.xpath("//li[.='Select Menu']"));
    }

    public void firstSelect(String option) {
        wd.findElement(By.cssSelector("div[id='selectMenuContainer'] div.row:nth-child(2) div.css-1wy0on6")).click();
        //wd.findElement(By.id("withOptGroup")).click();
        String locator = String.format("//*[.='%s']", option);
        wd.findElement(By.xpath(locator)).click();
        Assert.assertTrue(wd.findElement(By.cssSelector("div[class=' css-1uccc91-singleValue']")).getText().contains(option));

    }

    public void selectOne(String title) {
        //String locator = String.format("//*[.='%s']",title);
        WebElement el = wd.findElement(By.cssSelector("div[id='selectOne']"));
        el.click();
        // wd.findElement(By.xpath(locator)).click();
        switch (title) {         //with use of setTimeout(()=>console.log(document.querySelector("div[id='selectOne']").innerHTML),10000)
            case "Dr.":
                wd.findElement(By.id("react-select-3-option-0-0")).click();
                break;
            case "Mr.":
                wd.findElement(By.id("react-select-3-option-0-1")).click();
                break;
            case "Mrs.":
                wd.findElement(By.id("react-select-3-option-0-2")).click();
                break;
            case "Ms.":
                wd.findElement(By.id("react-select-3-option-0-3")).click();
                break;
            case "Prof.":
                wd.findElement(By.id("react-select-3-option-0-4")).click();
                break;
            case "Other":
                wd.findElement(By.id("react-select-3-option-0-5")).click();
                break;
        }

        Assert.assertTrue(el.getText().contains(title));
    }

    public void chooseColor(String color) {
        selectText(By.cssSelector("select[id='oldSelectMenu']"), color);
        WebElement e = wd.findElement(By.cssSelector("select[id='oldSelectMenu']"));
        Assert.assertTrue(e.getText().contains(color));
    }

    public void multiselectColors(String color) {
        String[] colors = color.split(",");
        wd.findElement(By.xpath("(//div[@class=' css-2b097c-container'])[3]")).click();
        pause(2000);
        for (int i = 0; i < colors.length; i++) {
            String locator = String.format("//div[.='%s']", colors[i]);
            wd.findElement(By.xpath(locator)).click();
            pause(2000);
            Assert.assertTrue(wd.findElement
                    (By.xpath("(//div[@class=' css-2b097c-container'])[3]")).getText().contains(colors[i]));

        }
        int colorsBefore = colors.length;//to delete the last color added
        String s = colors[colorsBefore - 1];
        System.out.println("Color to be deleted->>" + s);
        WebElement deleteCol = wd.findElement(By.xpath("//div[.='" + s + "']//div[@class='css-xb97g8']"));
        deleteCol.click();
        pause(2000);
        List<WebElement> list = wd.findElements
                (By.xpath("(//div[@class=' css-2b097c-container'])[3]"));
        Assert.assertTrue(list.size() < colors.length);

    }

    //    public void selectMultiCar(String car) {
//        String[] cars = car.split(",");
//        Select carSelect = new Select(wd.findElement(By.id("cars")));
//        if(carSelect.isMultiple()){
//            for (String c : cars) {
//                carSelect.selectByValue(c);
//            }
//        }
//    }
    public void selectMultiCar(String car) {
        String[] cars = car.split(",");
        Select carSelect = new Select(wd.findElement(By.id("cars")));
        if (carSelect.isMultiple()) {
            for (String c : cars) {
                switch (c) {
                    case ("volvo"):
                        carSelect.selectByValue("volvo");
                        break;
                    case ("saab"):
                        carSelect.selectByValue("saab");
                        break;
                    case ("opel"):
                        carSelect.selectByValue("opel");
                        break;
                    case ("audi"):
                        carSelect.selectByValue("audi");
                        break;

                }
            }
        }
    }
}