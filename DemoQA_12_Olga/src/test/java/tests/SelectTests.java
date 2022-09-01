package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SelectTests extends Base{

    @BeforeClass
    public void preConditions(){
        app.selector().hideAds();
        app.selector().selectWidget();
        app.selector().hideFooter();
        app.selector().selectSelectMenu();
    }
    @Test
    public void selectValue(){
        app.selector().firstSelect("Group 1, option 1");


    }


}
