package gui;

import graph.Graph;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private GraphPanel graphPanel;
    private ControlPanel controlPanel;

    public MainFrame(Graph graph) {

        setTitle("Network Flow Optimization System");

        setSize(1000,700);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        graphPanel = new GraphPanel(graph);

        controlPanel = new ControlPanel(graph);

        add(graphPanel, BorderLayout.CENTER);

        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
