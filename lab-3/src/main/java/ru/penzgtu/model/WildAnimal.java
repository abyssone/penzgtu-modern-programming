package ru.penzgtu.model;

public class WildAnimal extends Animal {

    private String habitat;

    private final static String feedingMethod = "охота";

    public WildAnimal(String kindOf, String family, int limbsNumber, int descendantsNumber, String habitat) {
        super(kindOf, family, limbsNumber, descendantsNumber);
        this.habitat = habitat;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Место обитания: " + habitat);
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return "WildAnimal{" +
                "habitat='" + habitat + '\'' +
                "} " + super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Уничтожен объект WildAnimal");
        super.finalize();
    }

    @Override
    public void printFeedingMethod() {
        System.out.println("Способ питания: " + feedingMethod);
    }
}
