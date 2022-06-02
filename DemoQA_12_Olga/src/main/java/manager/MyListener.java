package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Files;

public class MyListener extends AbstractWebDriverEventListener {

    public MyListener(){
        super();
    }
    Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("Start to find element with locator-->"+by);

    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("Element with locator-->"+by+" was found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("Something went wrong-->"+driver.getCurrentUrl());
        logger.info(throwable.getMessage());
        logger.info(String.valueOf (throwable.fillInStackTrace()));

        int i = (int)(System.currentTimeMillis())/1000%3600;
        String screenshotName = "DemoQA_12_Olga/src/test/screenshots/screenshot"+i+".png";
        HelperBase helper = new HelperBase(driver);
        helper.makeScreenShot(screenshotName);

    }
}
