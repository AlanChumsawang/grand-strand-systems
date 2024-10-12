package com.grandstrandsystems.test.contactservice;

import static org.junit.jupiter.api.Assertions.*;

import com.grandstrandsystems.contactservice.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1112", "Best", "MomEver", "1234567891", "123 MyHouse St");
        assertTrue(contactService.addContact(contact));
    }

    @Test
    public void testDeleteContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1112", "Best", "MomEver", "1234567891", "123 MyHouse St");
        contactService.addContact(contact);
        assertTrue(contactService.deleteContact("1112"));
    }

    @Test
    public void testUpdateContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1112", "Best", "MomEver", "1234567891", "123 MyHouse St");
        contactService.addContact(contact);
        assertTrue(contactService.updateContact("1112", "Best", "MomEver", "1234567891", "123 MyHouse St"));
    }
    @Test
    public void testAddDuplicateContact() {
        ContactService contactService = new ContactService();
        Contact contact1 = new Contact("1112", "Best", "MomEver", "1234567891", "123 MyHouse St");
        Contact contact2 = new Contact("1112", "Best", "MomEver", "1234567891", "123 MyHouse St");
        assertTrue(contactService.addContact(contact1));
        assertFalse(contactService.addContact(contact2));
    }

    @Test
    public void testDeleteFakeContact() {
        ContactService contactService = new ContactService();
        assertFalse(contactService.deleteContact("9999"));
    }

    @Test
    public void testUpdateFakeContact() {
        ContactService contactService = new ContactService();
        assertFalse(contactService.updateContact("9999", "FirstName", "LastName", "1234567890", "123 Random St"));
    }

    @Test
    public void testUpdateContactUsingInvalidValues() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1112", "Best", "MomEver", "1234567891", "123 MyHouse St");
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("1112", null, "LastName", "1234567890", "123 Random St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("1112", "FirstName", "LastName", "123456789", "123 Random St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("1112", "FirstName", "LastName", "1234567890", "1234567890123456789012345678901");
        });
    }

    @Test
    public void testSetInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1112", "Best", "MomEver1234567890123456789012345678901", "1234567891", "123 MyHouse St");
        });
    }



}