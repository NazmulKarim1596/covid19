package com.example.c_19;

public class Patients {


    String id;
    String name;
    String rank;
    String unit;
    String start;
    String end;

    public Patients(String id, String name, String rank, String unit, String start, String end) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.unit = unit;
        this.start = start;
        this.end = end;
    }

    public Patients(){



    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
