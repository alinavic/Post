package org.example.Classes;

import java.util.Date;

public class People {
    int id_people;
    String full_name, gender, passport_inf, phone_number;
    Date birthdate;

    public int getId_people() {
        return id_people;
    }

    public void setId_people(int id_people) {
        this.id_people = id_people;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassport_inf() {
        return passport_inf;
    }

    public void setPassport_inf(String passport_inf) {
        this.passport_inf = passport_inf;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
