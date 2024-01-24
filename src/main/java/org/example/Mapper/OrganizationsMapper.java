package org.example.Mapper;

import org.example.Classes.Organizations;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizationsMapper implements RowMapper<Organizations> {
    @Override
    public Organizations mapRow(ResultSet rs, int rowNum) throws SQLException {
        Organizations organizations = new Organizations();
        organizations.setId_org(rs.getInt("id_org"));
        organizations.setCode_org(rs.getInt("code_org"));
        organizations.setName_repres_org(rs.getString("name_repres_org"));
        organizations.setMail_org(rs.getString("mail_org"));
        return organizations;
    }
}
