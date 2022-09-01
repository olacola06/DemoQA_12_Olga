package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Stamm extends HelperBase {

    public Stamm(WebDriver wd) {
        super(wd);
    }

    public void tsam() {
        //WebDriver wd = new ChromeDriver();
        //wd.manage().window().maximize();
        //wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //wd.navigate().to("https://networx.atara2.networx.link/login");
        WebElement el1 = wd.findElement(By.cssSelector("input[name='username']"));
        el1.click();
        el1.clear();
        el1.sendKeys("atara+atara2_user_1188183@networx.com");

        WebElement el2 = wd.findElement(By.cssSelector("input[name='password']"));
        el2.click();
        el2.clear();
        el2.sendKeys("Manag3r1");

        wd.findElement(By.cssSelector("input[name='login']")).click();
        wd.findElement(By.cssSelector("a[href='/my_plans.php']")).click();
        wd.findElement(By.xpath("//li[@data-href='/pbl/edit_info.php?id=501349']/a")).click();

        String message = wd.findElement(By.cssSelector("div[class='lead-name']")).getText();
        Assert.assertTrue(message.contains("Post-Pay Per Lead"));

        List<WebElement> list = wd.findElements(By.cssSelector("div[class='selected-categories-list']"));
        int  sizeList = list.size();
        if (sizeList < 2) {
            for (int i = sizeList; i <= 2; i++) {
                String locator = "div[class='suggested-categories-list'] div[class='category-item ']:nth-child(" + i + ")";
//            new WebDriverWait(wd,10).until(ExpectedConditions.visibilityOf(
//                    wd.findElement(By.cssSelector(locator))));
                wd.findElement(By.cssSelector(locator)).click();
            }
        }
        System.out.println(list.size());
        Assert.assertEquals(list.size(), 2);
    }
}
//div[class='suggested-categories-list'] div[class='category-item ']:nth-child(1)

