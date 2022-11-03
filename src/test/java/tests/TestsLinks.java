package tests;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestsLinks {
    WebDriver driver;
    OkHttpClient client = new OkHttpClient();

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/links");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
//        driver.navigate().to("https://demoqa.com");
//        driver.findElement(By.xpath("//h5[.='Elements']")).click();
//        driver.findElement(By.xpath("//span[.='Links']")).click();
    }
    @Test
    public void linkAPI() throws IOException {
       new WebDriverWait(driver,10).until(ExpectedConditions
                .visibilityOf(driver.findElement(By.cssSelector("a[id='created']"))));
        driver.findElement(By.cssSelector("a[id='created']")).click();
        String responseCode = driver.findElement(By.xpath("(//p[@id='linkResponse']) /b[1]")).getText();
        String responseText = driver.findElement(By.xpath("(//p[@id='linkResponse']) /b[2]")).getText();

        Request request = new Request.Builder().url("https://demoqa.com/created")
                .get().build();
        Response response = client.newCall(request).execute();
        Assert.assertEquals(response.code(),Integer.parseInt(responseCode));
        Assert.assertEquals(response.message(),responseText);
    }
}
