import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestWithHideAds {

    WebDriver wd;

    @BeforeClass
    public void init(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("load-extension=/Users/tayahatum/Tools/5.0.2_0");

        wd =new ChromeDriver(options);
        wd.manage().window().maximize();
        wd.navigate().to("https://demoqa.com/");
        hideFooter();
        returnToDemoQa();

    }

    @BeforeMethod
    public void goToTextBox(){
//WebElement elementItem =
        wd.findElement(By.xpath("//h5[text()='Elements']")).click();
        wd.findElement(By.xpath("//li/span[text()='Text Box']")).click();
        hideFooter();
//elementItem.click();
    }


    @Test
    public void textBoxTest(){
        WebElement fullName = wd.findElement(By.id("userName"));
        fullName.click();
        fullName.clear();
        fullName.sendKeys("John Doe");

        WebElement email = wd.findElement(By.id("userEmail"));
        email.click();
        email.clear();
        email.sendKeys("john@mail.com");

        WebElement currentAddress = wd.findElement(By.id("currentAddress"));
        currentAddress.click();
        currentAddress.clear();
        currentAddress.sendKeys("Tel Aviv");

        WebElement addrees = wd.findElement(By.id("permanentAddress"));
        addrees.click();
        addrees.clear();
        addrees.sendKeys(" Yaffa Tel Aviv");

        wd.findElement(By.id("submit")).click();

        // Assert.assertEquals(wd.findElement(By.cssSelector("p#name")).getText(),"John Doe");
        Assert.assertTrue(wd.findElement(By.cssSelector("p#name")).getText().contains("John Doe"));





    }


    private void returnToDemoQa() {
        List<String> tabs = new ArrayList<>( wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1)).close();
        wd.switchTo().window(tabs.get(0));
    }


    private void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('footer').style.display='none';");
    }

}


