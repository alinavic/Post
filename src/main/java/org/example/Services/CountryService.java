package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.CountryDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryService {

    private final CountryDAO countryDAO;

    public List getAll(){ return countryDAO.getAll(); }

    public void setAll(String name) { countryDAO.setAll(name); }

    public void update(String name, String id_country) {
        if(name != null){
            countryDAO.update(name, Integer.parseInt(id_country));
        }
    }

    public void delete(String id_country) { countryDAO.delete(Integer.parseInt(id_country)); }
}
