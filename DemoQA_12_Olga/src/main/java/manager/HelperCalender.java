package manager;

import models.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperCalender extends HelperBase{

    public HelperCalender(WebDriver wd) {
        super(wd);
    }

    public void fillRegistForm(Student s) {
        type(By.id("firstName"),s.getFirstName());
        type(By.id("lastName"),s.getLastName());
        type(By.id("userEmail"),s.getEmail());
        chooseGender(s.getGender());
        type(By.id("userNumber"),s.getMobile());
        //type(By.id("dateOfBirthInput"),s.getDateOfBirth());
        type(By.id("subjectsInput"),s.getSubjects());
        selectText(By.cssSelector("div.col-md-3 col-sm-12"),s.getHobbies());
        type(By.id("currentAddress"),s.getAddress());
        selectValue(By.cssSelector("div. css-tlfecz-indicatorContainer"),s.getState());
        selectValue(By.cssSelector("div. css-1hwfws3"),s.getCity());
        //selectStateAndCity(s.getState(),s.getCity());

    }

    private void chooseGender(String gender) {
        String locator = String.format("//*[@value='%s']",gender);
        new WebDriverWait(wd,10).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        click(By.xpath(locator));
    }

    private void selectStateAndCity(String state, String city) {
        click(By.cssSelector("div. css-tlfecz-indicatorContainer"));
    }

    public void submit() {
        click(By.id("submit"));
    }
}
