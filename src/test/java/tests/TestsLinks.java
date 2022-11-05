package tests;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.hamcrest.core.StringContains;
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
import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

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
    public void linkAPICreate() throws IOException {
       new WebDriverWait(driver,10).until(ExpectedConditions
                .visibilityOf(driver.findElement(By.cssSelector("a[id='created']")))).click();
       pause(2000);
        String responseCode = driver.findElement(By.xpath("(//p[@id='linkResponse']) /b[1]")).getText();
        String responseText = driver.findElement(By.xpath("(//p[@id='linkResponse']) /b[2]")).getText();

        Request request = new Request.Builder().url("https://demoqa.com/created")
                .get().build();
        Response response = client.newCall(request).execute();
        Assert.assertEquals(response.code(),Integer.parseInt(responseCode));
        Assert.assertEquals(response.message(),responseText);
    }
    @Test
    public void linkAPIUnauthorized(){
        new WebDriverWait(driver,10).until(ExpectedConditions
                .visibilityOf(driver.findElement(By.cssSelector("a[id='unauthorized']")))).click();
        pause(2000);
        String responseCode = driver.findElement(By.xpath("(//p[@id='linkResponse']) /b[1]")).getText();
        String responseText = driver.findElement(By.xpath("(//p[@id='linkResponse']) /b[2]")).getText();

        given()
                .when()
                .get("https://demoqa.com/unauthorized")
                .then()
                .assertThat().statusCode(Integer.parseInt(responseCode))
                .assertThat().statusLine(containsString(responseText));

    }
    @Test
    public void linkNewTab(){
        new WebDriverWait(driver,10).until(ExpectedConditions
                .visibilityOf(driver.findElement(By.cssSelector("a[id='dynamicLink']")))).click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/");
        driver.switchTo().window(tabs.get(1)).close();
        driver.switchTo().window(tabs.get(0));

    }
    public void pause(int time){
        try{ Thread.sleep(time);

        }catch (InterruptedException e){
            throw new RuntimeException();
        }
    }
}
