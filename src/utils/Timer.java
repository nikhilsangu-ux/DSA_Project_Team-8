package utils;

public class Timer {

    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
    }

    public double getTimeInMilliseconds() {
        return (endTime - startTime) / 1_000_000.0;
    }
}
