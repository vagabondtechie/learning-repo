package me.maharana.ds.graph;

public class DirectedGraph extends Graph {

    public DirectedGraph(int vertexCount) {
        super(vertexCount);
    }

    @Override
    public boolean addEdge(int node1, int node2) throws IllegalArgumentException {
        if (!isValidNode(node1) || !isValidNode(node2))
            throw new IllegalArgumentException("Error: Invalid nodes");
        return getAdjacencyList().get(node1).add(node2);

    }

    @Override
    public void removeEdge(int node1, int node2) throws IllegalArgumentException {
        if (!isValidNode(node1) || !isValidNode(node2))
            throw new IllegalArgumentException("Error: Invalid nodes");
        getAdjacencyList().get(node1).remove(node2);
    }

    @Override
    public boolean edgeExists(int node1, int node2) throws IllegalArgumentException {
        if (!isValidNode(node1) || !isValidNode(node2))
            throw new IllegalArgumentException("Error: Invalid nodes");
        return getAdjacencyList().get(node1).contains(node2);
    }
}
