package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropAndDragTests extends Base{

    @BeforeClass
    public void preConditions(){
        app.actionH().hideAds();
        app.actionH().hideFooter();
        app.actionH().chooseInteractions();
    }

    @Test
    public void droppable(){
        app.actionH().clickDroppable();
        app.actionH().dragAndDropMe();


    }
}
