package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrokenLinksTests extends Base{

    @BeforeClass
    public void preConditions(){
        app.brokenLink().hideAds();
        app.brokenLink().hideFooter();
        app.brokenLink().chooseElements();
        app.brokenLink().hideFooter();
        app.brokenLink().chooseBrokenLinks();
    }
    @Test
    public void brokenLink(){
        app.brokenLink().checkBrokenLinks();
    }
}
