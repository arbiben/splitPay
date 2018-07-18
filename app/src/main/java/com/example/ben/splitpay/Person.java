package com.example.ben.splitpay;

public class Person {
    String firstName;
    String lastName;
    Accounts accounts;

    public Person(String fName, String lName, Accounts accounts){
        this.firstName = fName;
        this.lastName = lName;
        this.accounts = accounts;
    }
}
