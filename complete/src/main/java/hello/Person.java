package hello;

import javax.validation.constraints.NotEmpty;

public class Person {

    @NotEmpty
    private String personLastName;
    @NotEmpty
    private String firstName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.personLastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String lastName) {
        this.personLastName = lastName;
    }

    @Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " + personLastName;
    }

}
