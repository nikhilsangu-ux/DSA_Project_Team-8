package gui;

import algorithms.Dinic;
import algorithms.EdmondsKarp;
import graph.Graph;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    private Graph graph;

    public ControlPanel(Graph graph) {

        this.graph = graph;

        JButton dinicButton = new JButton("Run Dinic");
        JButton ekButton = new JButton("Run Edmonds-Karp");
        JButton compareButton = new JButton("Compare");
        JButton resetButton = new JButton("Reset");
        JButton exitButton = new JButton("Exit");

        setLayout(new FlowLayout(FlowLayout.CENTER,15,10));

        add(dinicButton);
        add(ekButton);
        add(compareButton);
        add(resetButton);
        add(exitButton);

        // ---------------- Dinic ----------------

        dinicButton.addActionListener(e -> {

            Graph copy = graph.copy();

            Dinic dinic = new Dinic(copy);

            int flow = dinic.maxFlow(0,5);

            JOptionPane.showMessageDialog(
                    this,
                    "Maximum Flow = " + flow,
                    "Dinic Algorithm",
                    JOptionPane.INFORMATION_MESSAGE
            );

        });

        // ------------ Edmonds-Karp ------------

        ekButton.addActionListener(e -> {

            Graph copy = graph.copy();

            EdmondsKarp ek = new EdmondsKarp(copy);

            int flow = ek.maxFlow(0,5);

            JOptionPane.showMessageDialog(
                    this,
                    "Maximum Flow = " + flow,
                    "Edmonds-Karp",
                    JOptionPane.INFORMATION_MESSAGE
            );

        });

        // -------- Performance Compare ---------

        compareButton.addActionListener(e -> {

            long start = System.nanoTime();

            Dinic dinic = new Dinic(graph.copy());

            int flow1 = dinic.maxFlow(0,5);

            long end = System.nanoTime();

            double dinicTime =
                    (end-start)/1_000_000.0;

            start = System.nanoTime();

            EdmondsKarp ek =
                    new EdmondsKarp(graph.copy());

            int flow2 = ek.maxFlow(0,5);

            end = System.nanoTime();

            double ekTime =
                    (end-start)/1_000_000.0;

            JOptionPane.showMessageDialog(
                    this,
                    "Dinic Maximum Flow : "
                    + flow1

                    + "\nDinic Time : "
                    + String.format("%.4f",dinicTime)
                    + " ms"

                    + "\n\nEdmonds-Karp Maximum Flow : "
                    + flow2

                    + "\nEdmonds-Karp Time : "
                    + String.format("%.4f",ekTime)
                    + " ms"

            );

        });

        // ---------------- Reset ----------------

        resetButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Graph has been reset."
            );

        });

        // ---------------- Exit ----------------

        exitButton.addActionListener(e -> System.exit(0));

    }
}