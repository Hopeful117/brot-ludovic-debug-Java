package com.hemebiotech;

public class Symptom {
    private String name;
    private int count;
    public Symptom(String name) {
        this.name = name;
        this.count = 0;
    }
    public String getName() {
        return name;
    }
    public int getCount() {
        return count;
    }
    public void incrementCount() {
        this.count++;
    }
    @Override
    public String toString() {
        return name + ": " + count;
    }
    @Override
    public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Symptom symptom = (Symptom) o;
    return name.equals(symptom.name);
}

    @Override
    public int hashCode() {
        return name.hashCode();
    }

   
    
}
