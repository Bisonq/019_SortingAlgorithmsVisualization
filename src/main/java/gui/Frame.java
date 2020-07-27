package gui;


import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame(Panel panel, OperationPanel operationPanel) {
        super();
        setTitle("AlgorithmsVisualization");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(new Dimension(800, 400));
        setLocation(100, 100);
        setResizable(false);
        add(panel);
        add(operationPanel);
        setVisible(true);
    }
}
