package com.example.model;

public class Person {
    private int id;
    private String name;
    private String yearOfBirth;
    private String gender;
    private String nationality;
    private int idCard;
    private String vehicle;
    private String numberVehicle;
    private int seats;
    private String starDate;
    private String endDate;
    private String text;
    private String addressContact;
    private String address;
    private int phone;
    private String email;

    public Person() {
    }

    public Person(int id, String name, String yearOfBirth, String gender, String nationality, int idCard, String vehicle, String numberVehicle, int seats, String starDate, String endDate, String text, String addressContact, String address, int phone, String email) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.numberVehicle = numberVehicle;
        this.seats = seats;
        this.starDate = starDate;
        this.endDate = endDate;
        this.text = text;
        this.addressContact = addressContact;
        this.address = address;
        this.phone = phone;
        this.email = email;
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

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getNumberVehicle() {
        return numberVehicle;
    }

    public void setNumberVehicle(String numberVehicle) {
        this.numberVehicle = numberVehicle;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAddressContact() {
        return addressContact;
    }

    public void setAddressContact(String addressContact) {
        this.addressContact = addressContact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
