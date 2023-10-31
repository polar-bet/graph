package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Function extends Validation {
    Scanner scanner = new Scanner(System.in);
    Graph graph = Graph.getInstance();

    public void printNodeList(){
        for (Vertex vertex : graph.getVertices()) {
            System.out.println("[" + vertex.getIndex() + "] - " + vertex.getName());
        }
    }
    public void findNode() throws Exception {
        System.out.println("Введіть ім'я або ID вершини:");
        Vertex vertex = getVertex();
        System.out.println("[" + vertex.getIndex() + "] - " + vertex.getName());
    }

    public void findChildren() throws Exception {
        System.out.println("Введіть ім'я або ID вершини:");
        Vertex vertex = getVertex();
        System.out.println("нащадки ноди " + vertex.getName() + ":");
        for (Vertex children : graph.findChildren(vertex.getIndex())) {
            System.out.println("[" + children.getIndex() + "] - " + children.getName());
        }
    }

    public void findShortestPath() throws Exception {
        System.out.println("Введіть ім'я або ID першої вершини:");
        Vertex source = getVertex();
        System.out.println("Введіть ім'я або ID другої вершини:");
        Vertex destination = getVertex();
        ArrayList<Vertex> path = graph.findShortestPath(source, destination);
        path.forEach(item -> {
            System.out.print(item + (path.indexOf(item) == path.size() - 1 ? "" : " → "));
        });
        System.out.println();
    }

    public Vertex getVertex() throws Exception {
        Vertex vertex;
        String inputValue = scanner.next();
            if (isInteger(inputValue)) {
                vertex = graph.findNodeById(Integer.parseInt(inputValue));
            } else {
                vertex = graph.findNodeByName(inputValue);
            }

            if (vertex == null) {
                throw new Exception("Ноду " + (isInteger(inputValue) ? "з індексом " : "") + inputValue + " не знайдено");
            }

            return vertex;
    }
}
