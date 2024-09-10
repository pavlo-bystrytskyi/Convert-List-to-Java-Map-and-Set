package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PharmacyTest {

    @Test
    void getCountTest_empty() {
        Pharmacy pharmacy = new Pharmacy();

        int expected = 0;
        int actual = pharmacy.getCount();

        assertEquals(expected, actual);
    }

    @Test
    void getCountTest_notEmpty() {
        Medication ibuprofen = new Medication("Ibuprofen", 0.5f, false);
        Medication nurofen = new Medication("Nurofen", 8f, true);
        Medication paracetamol = new Medication("Paracetamol", 1f, true);

        Pharmacy pharmacy = new Pharmacy();
        pharmacy.save(ibuprofen);
        pharmacy.save(nurofen);
        pharmacy.save(paracetamol);

        int expected = 3;
        int actual = pharmacy.getCount();

        assertEquals(expected, actual);
    }

    @Test
    void saveTest_once() {
        Medication ibuprofen = new Medication("Ibuprofen", 0.5f, false);

        Pharmacy pharmacy = new Pharmacy();
        pharmacy.save(ibuprofen);

        String expected = "[[Ibuprofen, price is 0.5€, is not available]]";
        String actual = pharmacy.toString();

        assertEquals(expected, actual);
    }

    @Test
    void saveTest_multipleTimes() {
        Medication ibuprofen1 = new Medication("Ibuprofen", 0.5f, false);
        Medication ibuprofen2 = new Medication("Ibuprofen", 0.5f, false);

        Pharmacy pharmacy = new Pharmacy();
        pharmacy.save(ibuprofen1);
        pharmacy.save(ibuprofen2);

        String expected = "[[Ibuprofen, price is 0.5€, is not available]]";
        String actual = pharmacy.toString();

        assertEquals(expected, actual);
    }

    @Test
    void saveTest_multiple() {
        Medication ibuprofen = new Medication("Ibuprofen", 0.5f, false);
        Medication nurofen = new Medication("Nurofen", 8f, true);
        Medication paracetamol = new Medication("Paracetamol", 1f, true);

        Pharmacy pharmacy = new Pharmacy();
        pharmacy.save(ibuprofen);
        pharmacy.save(nurofen);
        pharmacy.save(paracetamol);

        String[] expected = {
                "[Paracetamol, price is 1.0€, is available]",
                "[Ibuprofen, price is 0.5€, is not available]",
                "[Nurofen, price is 8.0€, is available]"
        };
        String actual = pharmacy.toString();

        for (String expectedMedication : expected) {
            boolean contains = actual.contains(expectedMedication);
            assertTrue(contains);
        }
    }

    @Test
    void findTest_exists() {
        Medication ibuprofen = new Medication("Ibuprofen", 0.5f, false);
        Medication nurofen = new Medication("Nurofen", 8f, true);
        Medication paracetamol = new Medication("Paracetamol", 1f, true);

        Pharmacy pharmacy = new Pharmacy();
        pharmacy.save(ibuprofen);
        pharmacy.save(nurofen);
        pharmacy.save(paracetamol);

        Medication expected = paracetamol;
        Medication actual = pharmacy.find("Paracetamol");

        assertEquals(expected, actual);
    }

    @Test
    void findTest_notExists() {
        Medication ibuprofen = new Medication("Ibuprofen", 0.5f, false);
        Medication nurofen = new Medication("Nurofen", 8f, true);
        Medication paracetamol = new Medication("Paracetamol", 1f, true);

        Pharmacy pharmacy = new Pharmacy();
        pharmacy.save(ibuprofen);
        pharmacy.save(nurofen);
        pharmacy.save(paracetamol);

        Medication expected = null;
        Medication actual = pharmacy.find("Ibufen");

        assertEquals(expected, actual);
    }

    @Test
    void deleteTest_exists() {
        Medication ibuprofen = new Medication("Ibuprofen", 0.5f, false);

        Pharmacy pharmacy = new Pharmacy();
        pharmacy.save(ibuprofen);

        pharmacy.delete("Ibuprofen");

        String expected = "[]";
        String actual = pharmacy.toString();

        assertEquals(expected, actual);
    }

    @Test
    void deleteTest_multipleTimes() {
        Medication ibuprofen = new Medication("Ibuprofen", 0.5f, false);

        Pharmacy pharmacy = new Pharmacy();
        pharmacy.save(ibuprofen);

        pharmacy.delete("Ibuprofen");
        pharmacy.delete("Ibuprofen");
        pharmacy.delete("Ibuprofen");

        String expected = "[]";
        String actual = pharmacy.toString();

        assertEquals(expected, actual);
    }

    @Test
    void deleteTest_notExists() {
        Medication ibuprofen = new Medication("Ibuprofen", 0.5f, false);

        Pharmacy pharmacy = new Pharmacy();
        pharmacy.save(ibuprofen);

        pharmacy.delete("Ibufen");

        String expected = "[[Ibuprofen, price is 0.5€, is not available]]";
        String actual = pharmacy.toString();

        assertEquals(expected, actual);
    }
}