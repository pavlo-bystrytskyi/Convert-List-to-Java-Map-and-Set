package org.example;

public class Main {
    public static void main(String[] args) {
        Medication ibuprofen = new Medication("Ibuprofen", 0.5f, false);
        Medication nurofen = new Medication("Nurofen", 8f, true);
        Medication paracetamol = new Medication("Paracetamol", 1f, true);

        Pharmacy pharmacy = new Pharmacy();
        pharmacy.save(ibuprofen);
        pharmacy.save(nurofen);
        pharmacy.save(paracetamol);

        System.out.println(pharmacy);

    }
}
