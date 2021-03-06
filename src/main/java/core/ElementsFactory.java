package core;

import java.util.Random;

public class ElementsFactory {

    private static final Random random = new Random();

    private ElementsFactory() {
    }

    public static Element createElement(int id) {

        return new Element(random.nextInt(101) - 50, id);
    }
}
