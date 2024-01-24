package org.example.Classes;

import java.util.Date;

public class EmployeeWindow {
    int id_employee, id_reception_window;
    Date date_change;

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public int getId_reception_window() {
        return id_reception_window;
    }

    public void setId_reception_window(int id_reception_window) {
        this.id_reception_window = id_reception_window;
    }

    public Date getDate_change() {
        return date_change;
    }

    public void setDate_change(Date date_change) {
        this.date_change = date_change;
    }
}
