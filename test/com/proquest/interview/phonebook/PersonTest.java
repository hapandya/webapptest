package com.proquest.interview.phonebook;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest{

    @Test
    public void getName(){
        Person person = new PersonBuilder()
                .setName("ProQuestName")
                .createPerson();

        String expectedName = person.getName();

        Assert.assertEquals("ProQuestName",expectedName);
    }

    @Test
    public void getPhoneNumber(){
        Person person = new PersonBuilder()
                .setPhoneNumber("111-111-1111")
                .createPerson();

        String expectedPhoneNumber = person.getPhoneNumber();

        Assert.assertEquals("111-111-1111", expectedPhoneNumber);
    }

    @Test
    public void getAddress(){
        Person person = new PersonBuilder()
                .setAddress("111 Ann Arbor, MI")
                .createPerson();

        String expectedAddress = person.getAddress();

        Assert.assertEquals("111 Ann Arbor, MI", expectedAddress);
    }
}