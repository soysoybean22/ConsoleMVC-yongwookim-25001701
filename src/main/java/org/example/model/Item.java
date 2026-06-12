package org.example.model;

public class Item {
    private final int id;
    private String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId()       { return id; }
    public String getName()  { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "[" + id + "] " + name;
    }
}
