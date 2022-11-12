package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    EventFiringWebDriver wd;
    String browser;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    HelperAlerts alert;
    HelperCalender calender;
    SelectHelper selector;
    ActionHelper actionH;
    Interactions inters;
    BrokenLinksHelper brokenLink;

    public void start() {
        if (browser.equals(BrowserType.CHROME)) {
            logger.info("All tests start in Chrome");
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("load-extension=C://Tools/4.46.1_0");
//            wd = new EventFiringWebDriver(new ChromeDriver(options));
            wd = new EventFiringWebDriver(new ChromeDriver());
        } else if (browser.equals(BrowserType.EDGE)) {
            logger.info("All tests start in Edge");
            wd = new EventFiringWebDriver(new EdgeDriver());
        } else if (browser.equals(BrowserType.FIREFOX)) {
            logger.info("All tests start in Edge");
            wd = new EventFiringWebDriver(new FirefoxDriver());
        }
        wd.register(new MyListener());

        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://demoqa.com/");
        alert = new HelperAlerts(wd);
        calender = new HelperCalender(wd);
        selector = new SelectHelper(wd);
        actionH = new ActionHelper(wd);
        inters = new Interactions(wd);
        brokenLink = new BrokenLinksHelper(wd);
    }

    public HelperAlerts alert() {
        return alert;
    }

    public HelperCalender calender() {
        return calender;
    }
    public SelectHelper selector() {
        return selector;
    }
    public ActionHelper actionH(){
        return actionH;
    }
    public Interactions inters(){
        return inters;
    }
    public BrokenLinksHelper brokenLink(){
        return brokenLink;
    }
    public void quit() {
        wd.quit();
    }
}

