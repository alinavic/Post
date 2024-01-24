package org.example.Classes;

import java.sql.Timestamp;

public class Queue {
    int id_window;
    String ticket, time_start, time_reception;

    public int getId_window() {
        return id_window;
    }

    public void setId_window(int id_window) {
        this.id_window = id_window;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_reception() {
        return time_reception;
    }

    public void setTime_reception(String time_reception) {
        this.time_reception = time_reception;
    }
}
