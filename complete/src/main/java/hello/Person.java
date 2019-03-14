package hello;

public class Person {

    private String personLastName;
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
