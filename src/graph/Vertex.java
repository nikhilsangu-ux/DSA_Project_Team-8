package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private int id;
    private List<Edge> edges;

    public Vertex(int id) {
        this.id = id;
        this.edges = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }
}
