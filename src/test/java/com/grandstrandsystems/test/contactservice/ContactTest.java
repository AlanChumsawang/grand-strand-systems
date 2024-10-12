package com.grandstrandsystems.test.contactservice;

import static org.junit.jupiter.api.Assertions.*;

import com.grandstrandsystems.contactservice.Contact;

import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreationSuccess() {
        Contact contact = new Contact("1111", "Alan", "Chumsawang", "1234567890", "123 Random St");
        assertEquals("1111", contact.getContactID());
        assertEquals("Alan", contact.getFirstName());
        assertEquals("Chumsawang", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Random St", contact.getAddress());
    }

    @Test
    public void testContactCreationWithInvalidValues() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "FirstName", "LastName", "1234567890", "123 Random St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "FirstName", "LastName", "1234567890", "123 Random St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "LastName", "1234567890", "123 Random St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "FirstName", "LastName", "123456789", "123 Random St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "FirstName", "LastName", "1234567890", "1234567890123456789012345678901");
        });
    }

    @Test
    public void testgetFirstName() {
        Contact contact = new Contact("1111", "Alan", "Chumsawang", "1234567890", "123 Random St");
        assertEquals("Alan", contact.getFirstName());
    }

    @Test
    public void testgetLastName() {
        Contact contact = new Contact("1111", "Alan", "Chumsawang", "1234567890", "123 Random St");
        assertEquals("Chumsawang", contact.getLastName());
    }

    @Test
    public void testgetPhone() {
        Contact contact = new Contact("1111", "Alan", "Chumsawang", "1234567890", "123 Random St");
        assertEquals("1234567890", contact.getPhone());
    }

    @Test
    public void testgetAddress() {
        Contact contact = new Contact("1111", "Alan", "Chumsawang", "1234567890", "123 Random St");
        assertEquals("123 Random St", contact.getAddress());
    }

}
