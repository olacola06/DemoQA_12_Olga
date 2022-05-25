package tests;

import manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class Base {

    protected static ApplicationManager app =
           new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));

    Logger logger  = LoggerFactory.getLogger(Base.class);

    @BeforeMethod
    public void loggerStart(Method m){
        logger.info("Starts test named:--> " + m.getName());
    }

    @AfterMethod
    public void loggerStop(Method m){
        logger.info("Finished test named:--> "+m.getName());

    }

    @BeforeSuite
    public void init(){
        app.start();
    }

//    @AfterSuite
//    public void stop(){
//        app.quit();
//    }
}
