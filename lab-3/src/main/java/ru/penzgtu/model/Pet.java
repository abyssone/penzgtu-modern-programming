package ru.penzgtu.model;

public class Pet extends Animal {

    private String name;
    private final static String feedingMethod = "кормит владелец";

    public Pet(String kindOf, String family, int limbsNumber, int descendantsNumber, String name) {
        super(kindOf, family, limbsNumber, descendantsNumber);
        this.name = name;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Кличка: " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Уничтожен объект Pet");
        super.finalize();
    }

    @Override
    public void printFeedingMethod() {
        System.out.println("Способ питания: " + feedingMethod);
    }
}
