package tests;

import models.Student;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCalender extends Base {

    @BeforeClass
    public void beforeStart(){
        //app.calender().switchWindows();
        app.calender().hideAds();
        app.calender().clickForms();
        app.calender().hideFooter();
    }

    @Test
    public void fillStudentRegistrationForm(){
        Student student = Student.builder().firstName("Olga").lastName("Mar").email("Ola@mail.ru").gender("Female")
                .mobile("0123456789").dateOfBirth("31/10/1995").subject("Math,History,Chemistry")//subject("First course student")//
                .hobbies("Sports,Music").address("Herzel 3, Tel Aviv").state("Haryana").city("Karnal").build();

        app.calender().fillRegistForm(student);
        app.calender().downloadPic();
        app.calender().submit();

        Assert.assertTrue(app.calender().formSubmitted());

    }
    @AfterClass
    public void postConditions(){
        app.calender().clickSubmitForm();
        app.calender().returnToMainPage();
    }
}
