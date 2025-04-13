package org.buildcode;

public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Address address;

    public Person(String firstName, String lastName, String phoneNumber, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}