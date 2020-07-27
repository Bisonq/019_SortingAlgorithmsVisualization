package core;

public class Element {

    private int value;
    private final int id;
    private final int xLocation;
    private final int yLocation;
    private final int radius;
    private final int space = 40;

    public Element(int value, int id) {
        this.value = value;
        this.id = id;
        this.radius = 50;
        this.xLocation = space + radius * id;
        this.yLocation = 130;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getxLocation() {
        return xLocation;
    }

    public int getyLocation() {
        return yLocation;
    }

    public int getRadius() {
        return radius;
    }
}
