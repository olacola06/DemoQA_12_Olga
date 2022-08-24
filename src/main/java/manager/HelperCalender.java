package manager;

import models.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperCalender extends HelperBase {

    public HelperCalender(WebDriver wd) {
        super(wd);
    }

    public void clickForms() {
        click(By.xpath("//*[text()='Forms']/ancestor::div[3]"));
        click(By.cssSelector("div.element-list.collapse.show"));
    }

    public void fillRegistForm(Student s) {
        type(By.id("firstName"), s.getFirstName());
        type(By.id("lastName"), s.getLastName());
        type(By.id("userEmail"), s.getEmail());
        chooseGender(s.getGender());
        type(By.id("userNumber"), s.getMobile());
        selectDateOfBirth(s.getDateOfBirth());
        type(By.cssSelector("input#subjectsInput"),s.getSubject());
        selectText(By.cssSelector("div.col-md-3 col-sm-12"), s.getHobbies());
        type(By.id("currentAddress"), s.getAddress());
        selectValue(By.cssSelector("div. css-tlfecz-indicatorContainer"), s.getState());
        selectValue(By.cssSelector("div. css-1hwfws3"), s.getCity());
        //selectStateAndCity(s.getState(),s.getCity());
    }

    private void selectDateOfBirth(String dateOfBirth) { //31/03/2005
        //String [] birthDate  = dateOfBirth.split("/");
        WebElement el = wd.findElement(By.id("dateOfBirthInput"));
        el.clear();
        el.click();
        LocalDate birthDate = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(birthDate.toString());
        String yearValue = String.valueOf(birthDate.getYear());
        String day = String.valueOf(birthDate.getDayOfMonth());
        selectValue((By.cssSelector(".react-datepicker__year-select")),yearValue);
        selectValue((By.cssSelector(".react-datepicker__month-select")),"" + (birthDate.getMonthValue()-1));
        //new Select(wd.findElement(By.cssSelector(".react-datepicker__month-select")))
                // .selectByValue("" + (birthDate.getMonthValue()-1));
        click(By.xpath("//div[.='"+day+"']"));

    }


    private void chooseGender(String gender) {
        if(gender == "Male"){
            click(By.xpath("//label[@for='gender-radio-1']"));
        }
        else if(gender == "Female"){
            click(By.xpath("//label[@for='gender-radio-2']"));
        }
        else{
            click(By.xpath("//label[@for='gender-radio-3']"));
        }
        //String locator = String.format("//*[@value='%s']",gender);
        //new WebDriverWait(wd,10).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
//        int number = findNeededGenderNumber(gender);
//        String locator = String.format("//label[@for='gender-radio-%s']", number);
//        click(By.xpath(locator));
    }

//    public int findNeededGenderNumber(String gender) {
//        int i;
//        if (gender == "Male") {
//            i = 1;
//            return i;
//        } else if (gender == "Female") {
//            i = 2;
//            return i;
//        }
//        return 3;
//    }

    private void selectStateAndCity(String state, String city) {
        click(By.cssSelector("div. css-tlfecz-indicatorContainer"));
    }

    public void submit() {
        click(By.id("submit"));
    }

    public void scrollDown() {
        wd.findElement(By.tagName("body")).sendKeys(Keys.DOWN);

    }
}
