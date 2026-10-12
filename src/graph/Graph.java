package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Vertex> vertices;

    public Graph(int verticesCount) {

        vertices = new ArrayList<>();

        for (int i = 0; i < verticesCount; i++) {
            vertices.add(new Vertex(i));
        }
    }

    public void addEdge(int from, int to, int capacity) {

        Edge forward = new Edge(from, to, capacity);
        Edge reverse = new Edge(to, from, 0);

        forward.setReverse(reverse);
        reverse.setReverse(forward);

        vertices.get(from).addEdge(forward);
        vertices.get(to).addEdge(reverse);
    }

    public Vertex getVertex(int id) {
        return vertices.get(id);
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public int size() {
        return vertices.size();
    }

    public Graph copy() {

        Graph copy = new Graph(size());

        for (Vertex vertex : vertices) {

            for (Edge edge : vertex.getEdges()) {

                if (edge.getCapacity() > 0) {
                    copy.addEdge(
                        edge.getFrom(),
                        edge.getTo(),
                        edge.getCapacity()
                    );
                }
            }
        }

        return copy;
    }
}