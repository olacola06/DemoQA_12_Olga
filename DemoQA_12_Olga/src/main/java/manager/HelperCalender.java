package manager;

import models.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
        //type(By.cssSelector("input#subjectsInput"),s.getSubject());
        enterSubject(s.getSubject());
        chooseHobbies(s.getHobbies());
        type(By.id("currentAddress"), s.getAddress());
        chooseStateAndCity(s.getState(),s.getCity());
    }

    private void chooseStateAndCity(String state, String city) {
        click(By.cssSelector("div[id='state'] div[class=' css-1wy0on6']"));
        String locator = String.format("//*[.='%s']",state);
        wd.findElement(By.xpath(locator)).click();

        click(By.cssSelector("div[id='city'] div[class=' css-1wy0on6']"));
        click(By.xpath("//*[.='"+city+"']"));
    }

    private void enterSubject(String subject) {
        String[]all = subject.split(",");
        for(String sub:all){
            wd.findElement(By.id("subjectsInput")).sendKeys(sub);
            wd.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
        }
    }

    private void chooseHobbies(String hobbies) {
        String[] all = hobbies.split(",");
        for (String hobby : all) {
            switch (hobby) {
                case ("Sports"):click(By.xpath("//label[@for='hobbies-checkbox-1']"));
                    break;
                case ("Reading"):click(By.xpath("//label[@for='hobbies-checkbox-2']"));
                    break;
                case ("Music"):click(By.xpath("//label[@for='hobbies-checkbox-3']"));
                    break;
            }
        }
    }
    private void selectDateOfBirth(String dateOfBirth) { //31/03/2005
        //String [] birthDate  = dateOfBirth.split("/");
        WebElement el = wd.findElement(By.id("dateOfBirthInput"));
        el.clear();
        el.click();
        LocalDate birthDate = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(birthDate.toString());
        String yearValue = String.valueOf(birthDate.getYear());
        int day = birthDate.getDayOfMonth();
        selectValue((By.cssSelector(".react-datepicker__year-select")),yearValue);
        selectValue((By.cssSelector(".react-datepicker__month-select")),"" + (birthDate.getMonthValue()-1));
        //new Select(wd.findElement(By.cssSelector(".react-datepicker__month-select")))
                // .selectByValue("" + (birthDate.getMonthValue()-1));
        chooseNeededDay(day);
     }

    private void chooseNeededDay(int day) {
        List<WebElement> list = wd.findElements(By.xpath("//div[.='" + day + "']"));
        if (list.size() > 1 && day>15) {
        list.get(1).click();
            } else {
                list.get(0).click();
            }
    }
     private void chooseGender(String gender) {
        if(gender.equals("Male")){
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

    public boolean formSubmitted() {
        String message = wd.findElement(By.cssSelector("div[class='modal-header']")).getText();
        return message.contains("Thanks for submitting the form");
    }

    public void downloadPic() {
        String linkName = "C:/Users/Olga/DemoQA_12_Olga/DemoQA_12_Olga/src/test/Image.jpg";
        WebElement el = wd.findElement(By.cssSelector("input[id='uploadPicture']"));
        el.sendKeys(linkName);
    }
}
