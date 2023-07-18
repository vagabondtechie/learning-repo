package me.maharana.ds.graph;

import java.util.ArrayList;
import java.util.List;

public abstract class Graph {

    private List<List<Integer>> adjacencyList;
    private int vertexCount;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        this.adjacencyList = new ArrayList<>(vertexCount);
        for (int i = 0; i < vertexCount; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public abstract boolean addEdge(int node1, int node2) throws IllegalArgumentException;

    public abstract void removeEdge(int node1, int node2) throws IllegalArgumentException;

    public abstract boolean edgeExists(int node1, int node2) throws IllegalArgumentException;

    protected boolean isValidNode(int node) {
        return node >= 0 && node < vertexCount;
    }

    protected List<List<Integer>> getAdjacencyList() {
        return this.adjacencyList;
    }

    public List<Integer> neighbors(int node) throws IllegalArgumentException {
        if (!isValidNode(node))
            throw new IllegalArgumentException("Error: Invalid node");
        return getAdjacencyList().get(node);
    }
}
