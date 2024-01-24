package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.OrganizationsDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrganizationsService {

    private final OrganizationsDAO organizationsDAO;

    public List getAll() {
        return organizationsDAO.getAll();
    }

    public void setAll (String code_org, String name_repres_org, String mail_org) {
        organizationsDAO.setAll(Integer.parseInt(code_org), name_repres_org, mail_org);
    }

    public void update (String id_org, String code_org, String name_repres_org, String mail_org) {
        if(!code_org.isEmpty()) {
            organizationsDAO.updateCodeOrg(Integer.parseInt(id_org), Integer.parseInt(code_org));
        }
        if(!name_repres_org.isEmpty()) {
            organizationsDAO.updateNameRepresOrg(Integer.parseInt(id_org), name_repres_org);
        }
        if(!mail_org.isEmpty()) {
            organizationsDAO.updateMailOrg(Integer.parseInt(id_org), mail_org);
        }
    }

    public void delete (String id_org) {
        organizationsDAO.delete(Integer.parseInt(id_org));
    }
}
