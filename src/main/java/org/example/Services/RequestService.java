package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.RequestDAO;
import org.example.Mapper.ShipmentsMapper;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;

@Service
@AllArgsConstructor
public class RequestService {

    private final RequestDAO requestDAO;

    public List one () {
        return requestDAO.one();
    }

    public List one2 () {
        return requestDAO.one2();
    }

    public List two(String full_name, String passport_inf) {
        return requestDAO.two(full_name, passport_inf);
    }

    public List four(String cost) {
        return requestDAO.four(cost);
    }

    public List five(String quarter) {
        if(Integer.parseInt(quarter) == 1){
            return requestDAO.five(1,3);
        }
        if(Integer.parseInt(quarter) == 2){
            return requestDAO.five(4,6);
        }
        if(Integer.parseInt(quarter) == 3){
            return requestDAO.five(7,9);
        }
        if(Integer.parseInt(quarter) == 4){
            return requestDAO.five(10,12);
        }
        return null;
    }

    public List six() {
        return requestDAO.six();
    }

    public String getNameMonth(String monthNumber) {
        try {
            if (Integer.parseInt(monthNumber) >= 1 && Integer.parseInt(monthNumber) <= 12) {
                Month month = Month.of(Integer.parseInt(monthNumber));
                return month.toString();
            } else {
                return "Неверный номер месяца";
            }
        } catch (Exception e) {
            return "Ошибка при преобразовании месяца";
        }
    }

    public List seven(String month) {
        return requestDAO.seven(Integer.parseInt(month));
    }

    public List eigth(String full_name, String passport_inf) {
        return requestDAO.eigth(full_name, passport_inf);
    }
}
