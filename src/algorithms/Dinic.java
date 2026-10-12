package algorithms;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Dinic {

    private Graph graph;
    private int[] level;

    public Dinic(Graph graph) {
        this.graph = graph;
        this.level = new int[graph.size()];
    }

    // Build Level Graph
    private boolean bfs(int source, int sink) {

        Arrays.fill(level, -1);

        Queue<Integer> queue = new LinkedList<>();

        level[source] = 0;
        queue.offer(source);

        while (!queue.isEmpty()) {

            int current = queue.poll();

            Vertex vertex = graph.getVertex(current);

            for (Edge edge : vertex.getEdges()) {

                if (level[edge.getTo()] == -1 &&
                        edge.getResidualCapacity() > 0) {

                    level[edge.getTo()] = level[current] + 1;
                    queue.offer(edge.getTo());
                }
            }
        }

        return level[sink] != -1;
    }

    // DFS to find blocking flow
    private int dfs(int current, int sink, int flow, int[] start) {

        if (current == sink) {
            return flow;
        }

        Vertex vertex = graph.getVertex(current);

        while (start[current] < vertex.getEdges().size()) {

            Edge edge = vertex.getEdges().get(start[current]);

            if (level[edge.getTo()] == level[current] + 1 &&
                    edge.getResidualCapacity() > 0) {

                int pushed = dfs(
                        edge.getTo(),
                        sink,
                        Math.min(flow, edge.getResidualCapacity()),
                        start
                );

                if (pushed > 0) {
                    edge.addFlow(pushed);
                    return pushed;
                }
            }

            start[current]++;
        }

        return 0;
    }

    // Maximum Flow
    public int maxFlow(int source, int sink) {

        int totalFlow = 0;

        while (bfs(source, sink)) {

            int[] start = new int[graph.size()];

            while (true) {

                int flow = dfs(
                        source,
                        sink,
                        Integer.MAX_VALUE,
                        start
                );

                if (flow == 0)
                    break;

                totalFlow += flow;
            }
        }

        return totalFlow;
    }
}
