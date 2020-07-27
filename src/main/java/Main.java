import gui.Frame;
import gui.OperationPanel;
import gui.Panel;

public class Main {
    public static void main(String[] args) {
        Panel panel = new Panel();
        OperationPanel operationPanel = new OperationPanel(panel);
        new Frame(panel, operationPanel);
    }
}
