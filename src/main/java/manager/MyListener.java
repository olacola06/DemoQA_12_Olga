package manager;


import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

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
//        String screenshotName = "C:/Users/Olga/DemoQA_12_Olga/DemoQA_12_Olga/src/test/screnshots/screenshot"+i+".png";
//        HelperBase helper = new HelperBase(driver);
//        helper.makeScreenShot(screenshotName);
        File screenshot = new File("C:/Users/Olga/DemoQA_12_Olga/DemoQA_12_Olga/src/test/screnshots/screenshot"+i+".png");
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(file,screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
