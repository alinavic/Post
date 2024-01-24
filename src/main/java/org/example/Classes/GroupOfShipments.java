package org.example.Classes;

import java.util.Date;

public class GroupOfShipments {
    int id_group;
    String number_group;
    Date date_dispatch, date_delivery;

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public String getNumber_group() {
        return number_group;
    }

    public void setNumber_group(String number_group) {
        this.number_group = number_group;
    }

    public Date getDate_dispatch() {
        return date_dispatch;
    }

    public void setDate_dispatch(Date date_dispatch) {
        this.date_dispatch = date_dispatch;
    }

    public Date getDate_delivery() {
        return date_delivery;
    }

    public void setDate_delivery(Date date_delivery) {
        this.date_delivery = date_delivery;
    }
}
