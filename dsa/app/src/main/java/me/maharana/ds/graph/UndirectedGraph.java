package me.maharana.ds.graph;

public class UndirectedGraph extends Graph {

    public UndirectedGraph(int vertexCount) {
        super(vertexCount);
    }

    @Override
    public boolean addEdge(int node1, int node2) throws IllegalArgumentException {
        if (!isValidNode(node1) || !isValidNode(node2))
            throw new IllegalArgumentException("Error: Invalid nodes");
        boolean s1 = getAdjacencyList().get(node1).add(node2);
        boolean s2 = getAdjacencyList().get(node2).add(node1);
        return s1 && s2;
    }

    @Override
    public void removeEdge(int node1, int node2) throws IllegalArgumentException {
        if (!isValidNode(node1) || !isValidNode(node2))
            throw new IllegalArgumentException("Error: Invalid nodes");
        getAdjacencyList().get(node1).remove(node2);
        getAdjacencyList().get(node2).remove(node1);
    }

    @Override
    public boolean edgeExists(int node1, int node2) throws IllegalArgumentException {
        if (!isValidNode(node1) || !isValidNode(node2))
            throw new IllegalArgumentException("Error: Invalid nodes");
        boolean s1 = getAdjacencyList().get(node1).contains(node2);
        boolean s2 = getAdjacencyList().get(node2).contains(node1);
        return s1 && s2;
    }
}
