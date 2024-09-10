package org.example;

import java.util.HashMap;
import java.util.Map;

public class Pharmacy {
    private Map<String, Medication> medications = new HashMap<String, Medication>();

    public int getCount() {
        return medications.size();
    }

    public void save(Medication medication) {
        medications.put(medication.getName(), medication);
    }

    public Medication find(String medicationName) {
        return medications.get(medicationName);
    }

    public void delete(String medicationName) {
        medications.remove(medicationName);
    }

    @Override
    public String toString() {
        return medications.values().toString();
    }

}
