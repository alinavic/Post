package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.PeopleDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PeopleService {

    private final PeopleDAO peopleDAO;

    public List getAll() {
        return peopleDAO.getAll();
    }

    public void setAll(String full_name, String gender, String birthdate, String passport_inf, String phone_number) { peopleDAO.setAll(full_name, gender, birthdate, passport_inf, phone_number); }

    public void update(String id_people, String full_name, String gender, String birthdate, String passport_inf, String phone_number) {
        if(!full_name.isEmpty()){
            peopleDAO.updateFullName(full_name, Integer.parseInt(id_people));
        }

        if(gender != null){
            peopleDAO.updateGender(gender, Integer.parseInt(id_people));
        }

        if(!birthdate.isEmpty()){
            peopleDAO.updateBirthdate(birthdate, Integer.parseInt(id_people));
        }

        if(!passport_inf.isEmpty()){
            peopleDAO.updatePassportInf(passport_inf, Integer.parseInt(id_people));
        }

        if(!phone_number.isEmpty()){
            peopleDAO.updatePhoneNumber(phone_number, Integer.parseInt(id_people));
        }
    }

    public void delete(String id_people) {
        peopleDAO.delete(Integer.parseInt(id_people));
    }
}
