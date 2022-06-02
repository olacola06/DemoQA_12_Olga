package tests;

import manager.HelperBase;
import models.Student;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCalender extends Base {

    @BeforeClass
    public void beforeStart(){
        app.calender().click(By.xpath("//*[text()='Forms']"));
        app.calender().click(By.cssSelector("div.element-list.collapse.show"));

    }

    @Test
    public void fillStudentRegistrationForm(){
        Student student = Student.builder().firstName("Olga").lastName("Mar").email("Ola@mail.ru").gender("Male")
                .mobile("123456789").dateOfBirth("01/03/2005").subjects("First course student").hobbies("Sport")
                .address("Herzel 3, Tel Aviv").state("Naryana").city("Karnal").build();

        app.calender().fillRegistForm(student);
        app.calender().submit();

    }
}
