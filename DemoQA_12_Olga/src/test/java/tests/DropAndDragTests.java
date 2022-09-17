package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropAndDragTests extends Base{

    @BeforeClass
    public void preConditions(){
        app.actionH().hideAds();
        app.actionH().hideFooter();
        app.actionH().chooseInteractions();
        app.actionH().hideFooter();
    }

    @Test
    public void droppable(){
        app.actionH().clickDroppable();
        app.actionH().dragAndDropMe();

        Assert.assertTrue(app.actionH().isDragAndDropDone());
    }
    @Test
    public void droppable2(){
        app.actionH().clickDroppable();
        app.actionH().dragAndDropMe2();

        Assert.assertTrue(app.actionH().isDragAndDropDone());
    }
}
