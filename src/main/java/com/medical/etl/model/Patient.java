package com.medical.etl.model;

public class Patient {

    private int id;
    private String gender;
    private double weight;
    private double height;
    private String state;
    private String city;
    private String district;

    public Patient() {
    }

    public Patient(int id, String gender, double weight, double height, String state, String city, String district) {
        this.id = id;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.state = state;
        this.city = city;
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                '}';
    }

}
