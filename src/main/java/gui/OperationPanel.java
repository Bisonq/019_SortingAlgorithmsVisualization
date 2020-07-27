package gui;

import algorithms.InsertionSort;
import algorithms.SelectionSort;

import javax.swing.*;
import java.awt.*;

public class OperationPanel extends JPanel {

    public OperationPanel(Panel panel){
        super();
        setLocation(50, 260);
        setSize(685, 90);
        setBackground(new Color(0, 166, 166));
        setLayout(new GridLayout(2,2));

        JLabel selectionSortlabel = new JLabel("iteration: " + 0);

        add(new SelectionSort(panel.getElements(), panel, selectionSortlabel));
        add(selectionSortlabel);

        JLabel insertionSortLabel = new JLabel("iteration " + 0);
        add(new InsertionSort(panel.getElements(), panel, insertionSortLabel));
        add(insertionSortLabel);
    }
}
