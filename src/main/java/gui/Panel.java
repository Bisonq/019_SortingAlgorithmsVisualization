package gui;

import core.Element;
import core.ElementsFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JPanel implements ActionListener {

    private List<Element> elements;
    private boolean elementsGenerated = false;
    private boolean isWorking = false;

    public Panel() {
        super();
        setLocation(50, 0);
        setSize(685, 250);
        setBackground(new Color(166, 166, 120));

        elements = new ArrayList<>();

        JButton generateElements = new JButton("Generate elements");
        generateElements.addActionListener(this);

        add(generateElements);
    }

    private int i = 1;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        paintNumbers(g2d, elements);
    }

    public void paintNumbers(Graphics2D g, List<Element> elements) {

        int fontSize = 18;
        g.setFont(new Font(Font.DIALOG, Font.BOLD, fontSize));

        for (Element e : elements) {
            g.drawOval(e.getxLocation(), e.getyLocation(), e.getRadius(), e.getRadius());
            g.drawString(e.getValue() + "", e.getxLocation() + e.getRadius() / 2 - fontSize / 2, e.getyLocation() + e.getRadius() / 2 + fontSize / 2);
        }
    }

    private void generateElements() {
        elements.clear();
        for (int i = 0; i < 12; i++)
            elements.add(ElementsFactory.createElement(i));
    }

    public List<Element> getElements() {
        return elements;
    }

    public boolean isElementsGenerated() {
        return elementsGenerated;
    }

    public void setElementsGenerated(boolean elementsGenerated) {
        this.elementsGenerated = elementsGenerated;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!elementsGenerated) {
            generateElements();
            elementsGenerated = true;
            repaint();
        }
    }
}
