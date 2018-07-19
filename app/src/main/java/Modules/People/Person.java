package Modules.People;

public class Person {
    private String firstName;
    private String lastName;
    private Account account;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String fName, String lName, Account account){
        this.firstName = fName;
        this.lastName = lName;
        this.account = account;
    }

    public String getInitials() {
        String firstInitial = getFirstInitial();
        String lastInitial = getLastInitial();

        return formatInitials(firstInitial, lastInitial);
    }

    private String getFirstInitial() {
        return firstName.substring(0,1);
    }

    private String getLastInitial() {
        return lastName.substring(0,1);
    }

    private String formatInitials(String first, String last) {
        return first + last;
    }

    @Override
    public String toString() {
        return formatFirstAndLast(firstName, lastName);
    }

    private String formatFirstAndLast(String first, String last) {
        return first + " " + last;
    }
}
