package com.example.mysqlite.modelClass;

public class ModelDataClass {

    private int id;
    private String name,mobileNumber;

    public ModelDataClass(int id, String name, String mobileNumber) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public ModelDataClass() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
