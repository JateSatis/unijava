package pract13;

import java.util.Objects;
import java.util.StringTokenizer;

class Address {
    public String country;
    public String region;
    public String city;
    public String street;
    public String house;
    public String building;
    public String apartment;

    public Address(String address, boolean isMultipleDelimiters) {
        if (isMultipleDelimiters) {
            StringTokenizer parts = new StringTokenizer(address, ",.;");
            this.country = parts.nextToken();
            this.region = parts.nextToken();
            this.city = parts.nextToken();
            this.street = parts.nextToken();
            this.house = parts.nextToken();
            this.building = parts.nextToken();
            this.apartment = parts.nextToken();
        }
        else {
            String[] parts = address.split(",");
            this.country = parts[0];
            this.region = parts[1];
            this.city = parts[2];
            this.street = parts[3];
            this.house = parts[4];
            this.building = parts[5];
            this.apartment = parts[6];
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}

public class ex3 {
    public static void main(String[] args) {
        Address address = new Address("Russia,Vologodskaya Oblast,Cherepovets,Ribinskaya,40,1,85", false);
//        Address address = new Address("Russia;Vologodskaya Oblast,Cherepovets.Ribinskaya.40;1,85", true);
        System.out.println(address.getCountry());
        System.out.println(address.getCity());
        System.out.println(address.getStreet());
        System.out.println(address.getApartment());
    }
}
