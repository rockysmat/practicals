package com.programming.techie;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//https://www.youtube.com/watch?v=flpmSXVTqBI&t=320s

class ContactManagerTest {

    ContactManager contactManager;

    @BeforeAll
    public static void setupAll(){
        System.out.println("Should print this message once before test execution starts");
    }

    @BeforeEach
    public void setup(){
        contactManager = new ContactManager();
    }

    @Test
    @DisplayName("Should create contact on a particular OS")
    @EnabledOnOs(value = OS.LINUX, disabledReason = "Enabled only on Linux")
    public void shouldCreateContact(){
        contactManager.addContact("John", "Doe", "0123456789");
        assertEquals(1, contactManager.getAllContacts().size());
        assertTrue(contactManager.getAllContacts().stream()
        .filter(contact -> contact.getFirstName().equals("John") &&
                contact.getLastName().equals("Doe") &&
                contact.getPhoneNumber().equals("0123456789"))
        .findAny().isPresent());
    }
    @Test
    @DisplayName("Should not create contact when first name is null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull(){
        assertThrows(RuntimeException.class, () ->
                contactManager.addContact(null, "Doe",  "0123456789"));
    }

    @Test
    @DisplayName("Should not create contact when last name is null")
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull(){
        assertThrows(RuntimeException.class, () ->
                contactManager.addContact("John",null, "0123456789"));
    }

    @Test
    @DisplayName("Should not create contact when phone number is null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull(){
        assertThrows(RuntimeException.class, ()->
                contactManager.addContact("John", "Doe", null));
    }

    @RepeatedTest(value = 2, name = "Repeating Contact Creation Test {currentRepetition} of {totalRepetitions}")
    @DisplayName("Test Contact Creation on Developer Machine")
    public void shouldTestContactCreationOnDev(){
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")));
        contactManager.addContact("John", "Doe", "0123456789");
        assertEquals(1, contactManager.getAllContacts().size());
        assertFalse(contactManager.getAllContacts().isEmpty());
    }

    @Nested
    class parameterizedTest {
        @DisplayName("Parameterized Contact Creation Test")
        @ParameterizedTest
        @ValueSource(strings = {"0123456789", "1123456780", "012345670009"})
        public void shouldTestContactCreationParameterized(String phoneNumber) {
            contactManager.addContact("John", "Doe", phoneNumber);
            assertEquals(1, contactManager.getAllContacts().size());
            assertFalse(contactManager.getAllContacts().isEmpty());
        }

        @DisplayName("CsvSource - Parameterized Contact Creation Test")
        @ParameterizedTest
        @CsvSource({"0123456789", "1123456789", "01234567899"})
        public void shouldTestContactCreationParameterizedByCsvSource(String phoneNumber) {
            contactManager.addContact("John", "Doe", phoneNumber);
            assertEquals(1, contactManager.getAllContacts().size());
            assertFalse(contactManager.getAllContacts().isEmpty());
        }
    }

    @DisplayName("MethodSource - Parameterized Contact Creation Test")
    @ParameterizedTest
    @MethodSource("phoneNumberList")
    public void shouldTestContactCreationParameterizedByMethodSource(String phoneNumber) {
        contactManager.addContact("John", "Doe", phoneNumber);
        assertEquals(1, contactManager.getAllContacts().size());
        assertFalse(contactManager.getAllContacts().isEmpty());
    }

    private static List<String> phoneNumberList(){
        return Arrays.asList("012345789", "0123457890", "512345789");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("Should be executed at the end of each unit test");
    }

    @AfterAll
    public static void tearDownAll(){
        System.out.println("Should be executed after all tests have been executed");
    }
}