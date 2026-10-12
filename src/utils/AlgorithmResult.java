package utils;

public class AlgorithmResult {

    private int maxFlow;
    private long executionTime;

    public AlgorithmResult(int maxFlow, long executionTime) {
        this.maxFlow = maxFlow;
        this.executionTime = executionTime;
    }

    public int getMaxFlow() {
        return maxFlow;
    }

    public long getExecutionTime() {
        return executionTime;
    }
}
