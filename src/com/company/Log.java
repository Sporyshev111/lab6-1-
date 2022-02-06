package com.company;

import java.util.Date;

public class Log{
    String operation;

    Date datatime;
    String [] name;

    public String getOperation() {
        return operation;
    }

    public Date getDatatime() {
        return datatime;
    }

    public String[] getName() {
        return name;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public Log(Date datatime,String operation, String[] name) {

        this.datatime = datatime;
        this.operation = operation;
        this.name = name;
    }


}
