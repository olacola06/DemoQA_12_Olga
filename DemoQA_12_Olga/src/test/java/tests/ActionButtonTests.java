package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionButtonTests extends Base{

    @BeforeClass
    public void preConditions(){
        app.actionH().hideAds();
        app.actionH().hideFooter();
        app.actionH().chooseElements();
        app.actionH().chooseButtons();

    }
    @Test
    public void  clicks(){
        app.actionH().doubleClickMe();
        Assert.assertTrue(app.actionH().isDoubleClickDone());
        app.actionH().rightClick();
        Assert.assertTrue(app.actionH().isRightClickDone());
        app.actionH().dynamicClick();
    }
    @AfterClass
    public void postConditions(){
        app.actionH().returnToMainPage();
    }

}
