package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    HelperAlerts alert;

    public void start(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("load-extension=C://Tools/4.46.1_0");
        //wd = new ChromeDriver();
        wd = new ChromeDriver(options);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://demoqa.com/");
        alert = new HelperAlerts(wd);
    }
    public HelperAlerts alert(){
        return alert;
    }
    public HelperAlerts withAlert(HelperAlerts alert){
        this.alert = alert;
        return alert;
    }

    public void  quit(){
        wd.quit();
    }
}
