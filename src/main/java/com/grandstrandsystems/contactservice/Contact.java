package com.grandstrandsystems.contactservice;

public class Contact {
    private String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        if (firstName == null || firstName.length() > 20) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (lastName == null || lastName.length() > 20) {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 20) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 20) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}