package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAlerts extends BaseAlerts {

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
}
