package org.example.Classes;

import java.util.Date;

public class Shipments {
    int id_shipm, recipient, sender, index_start,
            index_end, id_type, id_group, opcode,
            id_employee;
    String weight;
    Date retention_period;

    public int getId_shipm() {
        return id_shipm;
    }

    public void setId_shipm(int id_shipm) {
        this.id_shipm = id_shipm;
    }

    public int getRecipient() {
        return recipient;
    }

    public void setRecipient(int recipient) {
        this.recipient = recipient;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getIndex_start() {
        return index_start;
    }

    public void setIndex_start(int index_start) {
        this.index_start = index_start;
    }

    public int getIndex_end() {
        return index_end;
    }

    public void setIndex_end(int index_end) {
        this.index_end = index_end;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public int getOpcode() {
        return opcode;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Date getRetention_period() {
        return retention_period;
    }

    public void setRetention_period(Date retention_period) {
        this.retention_period = retention_period;
    }
}
