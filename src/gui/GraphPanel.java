package gui;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel {

    private Graph graph;

    public GraphPanel(Graph graph) {
        this.graph = graph;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if(graph == null)
            return;

        drawGraph(g);
    }

    private void drawGraph(Graphics g) {

        int[][] position = {

                {80,180},
                {250,80},
                {250,280},
                {450,80},
                {450,280},
                {650,180}
        };

        // Draw edges
        for(Vertex vertex : graph.getVertices()){

            int x1 = position[vertex.getId()][0];
            int y1 = position[vertex.getId()][1];

            for(Edge edge : vertex.getEdges()){

                if(edge.getCapacity()==0)
                    continue;

                int x2 = position[edge.getTo()][0];
                int y2 = position[edge.getTo()][1];

                g.setColor(Color.BLACK);

                g.drawLine(x1,y1,x2,y2);

                g.setColor(Color.RED);

                g.drawString(
                        String.valueOf(edge.getCapacity()),
                        (x1+x2)/2,
                        (y1+y2)/2
                );
            }
        }

        // Draw vertices
        for(Vertex vertex : graph.getVertices()){

            int x = position[vertex.getId()][0];
            int y = position[vertex.getId()][1];

            g.setColor(new Color(0,102,204));

            g.fillOval(x-20,y-20,40,40);

            g.setColor(Color.WHITE);

            g.drawString(
                    String.valueOf(vertex.getId()),
                    x-4,
                    y+5
            );
        }
    }
}
