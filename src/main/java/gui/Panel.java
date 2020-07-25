package gui;

import core.Element;
import core.ElementsFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JPanel {

    public Panel() {
        super();
        setLocation(50, 0);
        setSize(685, 300);
        setBackground(new Color(166, 166, 120));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        paintNumbers(g2d);
    }

    public void paintNumbers(Graphics2D g) {

        List<Element> elements = new ArrayList<>();
        generateElements(elements);

        int fontSize = 18;
        g.setFont(new Font(Font.DIALOG, Font.BOLD, fontSize));

        for (Element e : elements) {
            g.drawOval(e.getxLocation(), e.getyLocation(), e.getRadius(), e.getRadius());
            g.drawString(e.getValue() + "", e.getxLocation() + e.getRadius() / 2 - fontSize / 2, e.getyLocation() + e.getRadius() / 2 + fontSize / 2);
        }
    }

    private void generateElements(List<Element> elements) {
        for (int i = 0; i < 12; i++)
            elements.add(ElementsFactory.createElement());
    }
}
