package graph;

public class Edge {

    private int from;
    private int to;
    private int capacity;
    private int flow;

    private Edge reverse;

    public Edge(int from, int to, int capacity) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFlow() {
        return flow;
    }

    public int getResidualCapacity() {
        return capacity - flow;
    }

    public void addFlow(int amount) {
        flow += amount;
        reverse.flow -= amount;
    }

    public Edge getReverse() {
        return reverse;
    }

    public void setReverse(Edge reverse) {
        this.reverse = reverse;
    }
}
