package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class VertexTest {
    Graph graph = Graph.getInstance();

    @Test
    public void testFindChildren() {
        graph.addVertex("A");
        ArrayList<Vertex> vertexChildren = graph.getVertex(0).getNeighbors();
        ArrayList<Vertex> foundVertexChildren = graph.findChildren(0);
        assertEquals(vertexChildren, foundVertexChildren);
    }

    @Test
    public void testFindNodeById() {
        graph.addVertex("A");
        Vertex vertex = graph.getVertex(0);
        Vertex foundVertex = graph.findNodeById(0);
        assertEquals(vertex, foundVertex);
    }

    @Test
    public void testFindNodeByName() {
        graph.addVertex("A");
        Vertex foundVertex = graph.findNodeByName("A");
        graph.getVertices().forEach(item -> {
            if (item.getName().equals("A"))
                assertEquals(item, foundVertex);
        });
    }
}

