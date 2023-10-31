package org.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

class Graph {
    private int currentNumber = 0;
    private ArrayList<Vertex> vertices = new ArrayList<>();
    private static Graph INSTANCE;

    public static Graph getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Graph();
        }
        return INSTANCE;
    }

    private Graph() {
    }

    public void addVertex(String vertexName) {
        vertices.add(new Vertex(++currentNumber, vertexName));
    }

    public void addEdge(int source, int destination) {
        Vertex sourceNode = vertices.get(source);
        Vertex destinationNode = vertices.get(destination);

        if (sourceNode != null && destinationNode != null) {
            sourceNode.addNeighbor(destinationNode);
            destinationNode.addNeighbor(sourceNode);
        }
    }

    public Vertex getVertex(int vertexId) {
        return vertices.get(vertexId);
    }

    public ArrayList<Vertex> getVertices() {
        return new ArrayList<>(vertices);
    }

    public Vertex findNodeById(int vertexId) {
        for (Vertex vertex : vertices) {
            if (vertex.getIndex() == vertexId) {
                return vertex;
            }
        }
        return null;
    }

    public ArrayList<Vertex> findChildren(int vertexId) {
        Vertex node = vertices.get(vertexId);
        if (node != null) {
            return node.getNeighbors();
        }
        return new ArrayList<>();
    }

    public Vertex findNodeByName(String vertexName) {
        for (Vertex vertex : vertices) {
            if (vertex.getName().equals(vertexName)) {
                return vertex;
            }
        }
        return null;
    }


    public ArrayList<Vertex> findShortestPath(Vertex source, Vertex destination) {
        Map<Vertex, Vertex> previous = new HashMap<>();
        Map<Vertex, Integer> distance = new HashMap<>();
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));

        distance.put(source, 0);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            if (current == destination) {
                ArrayList<Vertex> path = new ArrayList<>();
                Vertex step = destination;
                while (step != null) {
                    path.add(step);
                    step = previous.get(step);
                }
                Collections.reverse(path);
                return path;
            }

            for (Vertex neighbor : current.getNeighbors()) {
                int newDistance = distance.get(current) + 1; // Використовуємо фіксовану відстань 1 між сусідніми вершинами.

                if (!distance.containsKey(neighbor) || newDistance < distance.get(neighbor)) {
                    distance.put(neighbor, newDistance);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        return new ArrayList<>();
    }


}