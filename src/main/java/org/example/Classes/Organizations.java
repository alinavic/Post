package org.example.Classes;

public class Organizations {
    int id_org;

    public int getId_org() {
        return id_org;
    }

    public void setId_org(int id_org) {
        this.id_org = id_org;
    }

    public int getCode_org() {
        return code_org;
    }

    public void setCode_org(int code_org) {
        this.code_org = code_org;
    }

    public String getName_repres_org() {
        return name_repres_org;
    }

    public void setName_repres_org(String name_repres_org) {
        this.name_repres_org = name_repres_org;
    }

    public String getMail_org() {
        return mail_org;
    }

    public void setMail_org(String mail_org) {
        this.mail_org = mail_org;
    }

    int code_org;
    String name_repres_org, mail_org;
}
