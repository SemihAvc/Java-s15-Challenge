package com.workintech.library.Persons;

import com.workintech.library.Book;
import com.workintech.library.Enums.Kategory;
import com.workintech.library.Enums.KitapDurumu;
import com.workintech.library.Enums.PersonalRoles;

public abstract class  Person {
private String name;
private  String surname;
private  long phoneNumber;
private  String  email;
private  long TCKN;
private PersonalRoles personalRoles;

    public Person(String name, String surname, long TCKN) {
        this.name = name;
        this.surname = surname;
        this.TCKN = TCKN;
    }

    public Person(String name, String surname, String email, long TCKN) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.TCKN = TCKN;
    }

    public Person(String name, String surname, long TCKN, PersonalRoles personalRoles) {
        this.name = name;
        this.surname = surname;
        this.TCKN = TCKN;
        this.personalRoles = personalRoles;
    }

    public Person(String name, String surname, PersonalRoles personalRoles) {
        this.name = name;
        this.surname = surname;
        this.personalRoles = personalRoles;
    }

    public Person(String email, long TCKN) {
        this.email = email;
        this.TCKN = TCKN;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTCKN() {
        return TCKN;
    }

    public void setTCKN(long TCKN) {
        this.TCKN = TCKN;
    }

    public PersonalRoles getPersonalRoles() {
        return personalRoles;
    }

    public void setPersonalRoles(PersonalRoles personalRoles) {
        this.personalRoles = personalRoles;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", TCKN=" + TCKN +
                ", personalRoles=" + personalRoles +
                '}';
    }

}
