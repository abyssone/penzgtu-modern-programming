package ru.penzgtu.model;

public abstract class Animal implements Mammal {
    private String kindOf;
    private String family;
    private int limbsNumber;
    private int descendantsNumber;

    public void print() {
        System.out.println("Вид: " + kindOf);
        System.out.println("Семейство: " + family);
        System.out.println("Количество конечностей: " + limbsNumber);
        System.out.println("Количество потомков: " + descendantsNumber);
    }

    public Animal(String kindOf, String family, int limbsNumber, int descendantsNumber) {
        this.kindOf = kindOf;
        this.family = family;
        this.limbsNumber = limbsNumber;
        this.descendantsNumber = descendantsNumber;
    }

    public Animal() {
    }

    public String getKindOf() {
        return kindOf;
    }

    public void setKindOf(String kindOf) {
        this.kindOf = kindOf;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getLimbsNumber() {
        return limbsNumber;
    }

    public void setLimbsNumber(int limbsNumber) {
        this.limbsNumber = limbsNumber;
    }

    public int getDescendantsNumber() {
        return descendantsNumber;
    }

    public void setDescendantsNumber(int descendantsNumber) {
        this.descendantsNumber = descendantsNumber;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "kindOf='" + kindOf + '\'' +
                ", family='" + family + '\'' +
                ", limbsNumber=" + limbsNumber +
                ", descendantsNumber=" + descendantsNumber +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Уничтожен объект Animal");
        super.finalize();
    }
}
