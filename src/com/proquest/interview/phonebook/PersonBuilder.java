package com.proquest.interview.phonebook;

public class PersonBuilder {
    private String name;
    private String phoneNumber;
    private String address;

    public Person createPerson() {
        return new Person(name, phoneNumber, address);
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }
}