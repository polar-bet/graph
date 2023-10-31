package org.example;

import java.util.ArrayList;
import java.util.List;

class Vertex {
    private int index;
    private String name;
    private ArrayList neighbors;

    public Vertex(int index, String name) {
        this.index = index;
        this.name = name;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Vertex neighbor) {
        neighbors.add(neighbor);
    }

    public String getName() {
        return name;
    }
    public int getIndex() {
        return index;
    }

    public ArrayList<Vertex> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return name;
    }
}
