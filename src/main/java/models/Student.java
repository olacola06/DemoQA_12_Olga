package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder

public class Student {
    String firstName;
    String lastName;
    String email;
    String gender;
    String mobile;
    String dateOfBirth;
    String subjects;
    String hobbies;
    String address;
    String state;
    String city;

}
