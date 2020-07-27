package algorithms;

import core.Element;
import gui.Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class SelectionSort extends JButton implements ActionListener {

    private List<Element> elements;
    private Panel panel;
    private JLabel label;
    private boolean sorted = false;

    public SelectionSort(List<Element> elements, Panel panel, JLabel label){
        super();
        setText("SelectionSort");
        this.elements = elements;
        this.panel = panel;
        this.label = label;
        addActionListener(this);
    }

    public void selectionSort(){

        if(panel.isElementsGenerated() && !panel.isWorking()) {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    panel.setWorking(true);
                    int i = 0;
                    int min;
                    while (i < elements.size()) {
                        min = indexOfMin(i);
                        swap(i, min);
                        i++;
                        label.setText("iteration: " + i);
                        panel.repaint();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    panel.setWorking(false);
                    panel.setElementsGenerated(false);
                }
            }, 1000);
        }
    }

    private int indexOfMin(int i){
        int min = i;

        for(int j = i+1 ; j < elements.size() ; j++){
            if(elements.get(min).getValue() > elements.get(j).getValue())
                min = j;
        }
        return min;
    }

    private void swap(int i, int min) {
        int value = elements.get(i).getValue();
        elements.get(i).setValue(elements.get(min).getValue());
        elements.get(min).setValue(value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        selectionSort();
    }
}
