package algorithms;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

import java.util.LinkedList;
import java.util.Queue;

public class EdmondsKarp {

    private Graph graph;

    public EdmondsKarp(Graph graph) {
        this.graph = graph;
    }

    private boolean bfs(int source, int sink, Edge[] parent) {

        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            Vertex vertex = graph.getVertex(current);

            for (Edge edge : vertex.getEdges()) {

                if (!visited[edge.getTo()]
                        && edge.getResidualCapacity() > 0) {

                    visited[edge.getTo()] = true;
                    parent[edge.getTo()] = edge;

                    queue.offer(edge.getTo());

                    if (edge.getTo() == sink) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public int maxFlow(int source, int sink) {

        int maxFlow = 0;

        while (true) {

            Edge[] parent = new Edge[graph.size()];

            if (!bfs(source, sink, parent)) {
                break;
            }

            int pathFlow = Integer.MAX_VALUE;

            int current = sink;

            while (current != source) {

                Edge edge = parent[current];

                pathFlow = Math.min(
                        pathFlow,
                        edge.getResidualCapacity()
                );

                current = edge.getReverse().getTo();
            }

            current = sink;

            while (current != source) {

                Edge edge = parent[current];

                edge.addFlow(pathFlow);

                current = edge.getReverse().getTo();
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }
}
