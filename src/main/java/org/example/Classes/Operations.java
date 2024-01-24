package org.example.Classes;

import java.util.Date;

public class Operations {
    int opcode;
    String name_op;
    Date date_begin, date_end;

    public int getOpcode() {
        return opcode;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    public String getName_op() {
        return name_op;
    }

    public void setName_op(String name_op) {
        this.name_op = name_op;
    }

    public Date getDate_begin() {
        return date_begin;
    }

    public void setDate_begin(Date date_begin) {
        this.date_begin = date_begin;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }
}
