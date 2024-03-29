package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAlerts extends Base {

    @BeforeMethod
    public void preCondition() {
        app.alert().clickAlertsBtn();
        app.alert().chooseAlerts();
    }

    @Test
    public void alertsBtn() {
        app.alert().alertButton1();
        app.alert().alertButton2();
        app.alert().alertButton3();
        app.alert().alertButton4();
    }

    @Test
    public void testTask(){

    }
    @AfterClass
    public void postConditions(){
        app.alert().returnToMainPage();
    }

}

