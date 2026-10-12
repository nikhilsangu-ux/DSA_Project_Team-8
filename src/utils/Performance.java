package utils;

import algorithms.Dinic;
import algorithms.EdmondsKarp;
import graph.Graph;

public class Performance {

    public static void compare(Graph originalGraph, int source, int sink) {

        // ---------- Dinic ----------
        Graph dinicGraph = originalGraph.copy();

        Timer timer = new Timer();

        timer.start();
        Dinic dinic = new Dinic(dinicGraph);
        int dinicFlow = dinic.maxFlow(source, sink);
        timer.stop();

        double dinicTime = timer.getTimeInMilliseconds();

        // ---------- Edmonds-Karp ----------
        Graph ekGraph = originalGraph.copy();

        timer = new Timer();

        timer.start();
        EdmondsKarp ek = new EdmondsKarp(ekGraph);
        int ekFlow = ek.maxFlow(source, sink);
        timer.stop();

        double ekTime = timer.getTimeInMilliseconds();

        System.out.println("--------------------------------------");
        System.out.println(" Performance Comparison");
        System.out.println("--------------------------------------");

        System.out.println("Dinic");
        System.out.println("Maximum Flow : " + dinicFlow);
        System.out.printf("Execution Time : %.6f ms%n", dinicTime);

        System.out.println();

        System.out.println("Edmonds-Karp");
        System.out.println("Maximum Flow : " + ekFlow);
        System.out.printf("Execution Time : %.6f ms%n", ekTime);

        System.out.println();

        if (dinicTime < ekTime) {
            System.out.println("Dinic was faster.");
        } else if (ekTime < dinicTime) {
            System.out.println("Edmonds-Karp was faster.");
        } else {
            System.out.println("Both took approximately the same time.");
        }
    }
}
