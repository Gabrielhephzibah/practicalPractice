package com.cherish.practicalpractice.paging;

public class ItemList {
    private String mooveId;
    private  String year;
    private String make;
    private String model;
    private  String vehicleId;
    private  String id;
    private  String carRegNo;

    public ItemList(String mooveId, String year, String make, String model, String vehicleId, String id, String carRegNo) {
        this.mooveId = mooveId;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleId = vehicleId;
        this.id = id;
        this.carRegNo = carRegNo;
    }


    public String getMooveId() {
        return mooveId;
    }

    public void setMooveId(String mooveId) {
        this.mooveId = mooveId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarRegNo() {
        return carRegNo;
    }

    public void setCarRegNo(String carRegNo) {
        this.carRegNo = carRegNo;
    }
}
