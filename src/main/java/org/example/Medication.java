package org.example;

import java.util.Objects;

public class Medication {
    private String name;
    private float price;
    private boolean available;

    public Medication(String name, float price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medication that = (Medication) o;
        return getPrice() == that.getPrice() && isAvailable() == that.isAvailable() && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), isAvailable());
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return String.format("[%s, price is %s€, is%s available]", name, price, available ? "" : " not");
    }
}
