package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SelectTests extends Base{

    @BeforeClass
    public void preConditions(){
        app.selector().hideAds();
        app.selector().hideFooter();
        app.selector().selectWidget();
        app.selector().hideFooter();
        app.selector().selectSelectMenu();
    }
    @Test
    public void selectValue(){
        app.selector().firstSelect("Group 1, option 1");
        app.selector().pause(2000);
        app.selector().firstSelect("Group 2, option 1");
        app.selector().pause(2000);
        app.selector().firstSelect("A root option");

    }
    @Test
    public void selectOne(){
        app.selector().selectOne("Other");
        app.selector().pause(2000);
        app.selector().selectOne("Mr.");
        app.selector().pause(2000);
        app.selector().selectOne("Prof.");
    }
    @Test
    public void oldStyleSelect(){
        app.selector().chooseColor("Blue");
        app.selector().pause(2000);
        app.selector().chooseColor("Black");
        app.selector().pause(2000);
        app.selector().chooseColor("Aqua");
    }
    @Test
    public void multiselectDropDownTest(){
        app.selector().multiselectColors("Blue,Red,Green");
    }

    @Test
    public void testStandartMultiSelect(){
        app.selector().selectMultiCar("volvo,saab,opel");
    }


}
