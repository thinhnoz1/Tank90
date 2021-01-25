import javax.swing.*;
import java.awt.*;

public class TankFrame extends JFrame {
    public static final int W = 510;
    public static final int H = 530;

    public TankFrame() throws HeadlessException {
        setSize(W, H);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Tank 90");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new TankPanel());
    }

    public static void main(String[] args) {
        TankFrame frame = new TankFrame();
        frame.setVisible(true);
    }
}
