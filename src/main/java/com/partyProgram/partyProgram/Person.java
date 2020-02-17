package com.partyProgram.partyProgram;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue
    Long id;
    String name, favouriteDrink;
    int age;
    boolean isAttendingParty;

    public Person(){ }

    public Person(String name, String favouriteDrink, int age, boolean isAttendingParty) {
        this.name = name;
        this.favouriteDrink = favouriteDrink;
        this.age = age;
        this.isAttendingParty = isAttendingParty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavouriteDrink() {
        return favouriteDrink;
    }

    public void setFavouriteDrink(String favouriteDrink) {
        this.favouriteDrink = favouriteDrink;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAttendingParty() {
        return isAttendingParty;
    }

    public void setAttendingParty(boolean attendingParty) {
        isAttendingParty = attendingParty;
    }

    @Override
    public String toString(){
        return "Name: "+this.name+"\n"+"   Age: "+this.age+"\n"+"   Favourite drink: "+this.favouriteDrink;
    }
}
