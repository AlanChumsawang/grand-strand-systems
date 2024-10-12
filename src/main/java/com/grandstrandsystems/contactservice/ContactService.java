package com.grandstrandsystems.contactservice;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact
    public boolean addContact(Contact contact) {
        // check if ID already exist
        if (contacts.containsKey(contact.getContactID())) {
            return false;  // Duplicate ID
        }
        contacts.put(contact.getContactID(), contact);
        return true;
    }

    // Delete a contact by ID
    public boolean deleteContact(String contactID) {
        if (contacts.containsKey(contactID)) {
            contacts.remove(contactID);
            return true;
        }
        return false;
    }

    // Update contact fields by contact ID
    public boolean updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            return false;  // Contact not found
        }
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
        return true;
    }
}