package algorithms;

import core.Element;
import gui.Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class InsertionSort extends JButton implements ActionListener {

    private List<Element> elements;
    private Panel panel;
    private JLabel label;

    public InsertionSort(List<Element> elements, Panel panel, JLabel label){
        super();
        setText("InsertionSort");
        this.elements = elements;
        this.panel = panel;
        this.label = label;
        addActionListener(this);
    }

    public void insertionSort(){
        if(panel.isElementsGenerated() && !panel.isWorking()){
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                for(int next = 1; next < elements.size() ; next ++) {

                    int curr = next;
                    int tmp = elements.get(next).getValue();

                    while((curr > 0) && (tmp < elements.get(curr - 1).getValue())) {

                        elements.get(curr).setValue(elements.get(curr-1).getValue());
                        curr--;

                    }
                    elements.get(curr).setValue(tmp);

                    label.setText("iteration: " + (next));
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

    @Override
    public void actionPerformed(ActionEvent e) {
        insertionSort();
    }
}
