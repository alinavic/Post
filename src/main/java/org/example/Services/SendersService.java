package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.SendersDAO;
import org.example.Mapper.SendersMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SendersService {

    private final SendersDAO sendersDAO;

    public List getAll() {
        return sendersDAO.getAll();
    }

    public void setAll(String id_country, String id_people, String id_org, String address) {
        sendersDAO.setAll(Integer.parseInt(id_country), Integer.parseInt(id_people), Integer.parseInt(id_org), address);
    }

    public void update (String id_sender, String id_country, String id_people, String id_org, String address) {
      if(!id_country.isEmpty()){
          sendersDAO.updateCountry(Integer.parseInt(id_sender), Integer.parseInt(id_country));
      }
      if(!id_people.isEmpty()){
          sendersDAO.updatePeople(Integer.parseInt(id_sender), Integer.parseInt(id_people));
      }
      if(!id_org.isEmpty()){
          sendersDAO.updateOrg(Integer.parseInt(id_sender), Integer.parseInt(id_org));
      }
      if(!address.isEmpty()){
          sendersDAO.updateAddress(Integer.parseInt(id_sender), address);
      }
    }

    public void delete (String id_sender) {
        sendersDAO.delete(Integer.parseInt(id_sender));
    }
}
