package tests;

import models.Student;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCalender extends Base {

    @BeforeClass
    public void beforeStart(){
        app.calender().switchWindows();
        //app.calender().scrollDown();
        app.calender().clickForms();
    }

    @Test
    public void fillStudentRegistrationForm(){
        Student student = Student.builder().firstName("Olga").lastName("Mar").email("Ola@mail.ru").gender("Female")
                .mobile("123456789").dateOfBirth("31/10/2005").subjects("First course student").hobbies("Sport")
                .address("Herzel 3, Tel Aviv").state("Naryana").city("Karnal").build();

        app.calender().fillRegistForm(student);
        app.calender().submit();

    }
}
