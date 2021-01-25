import javax.swing.*;
import java.awt.*;

public class ImageLoader {
    static Image getImage(String name) {
        ImageIcon icon = new ImageIcon(
                new ImageLoader()
                        .getClass()
                        .getResource("/images/" + name)
        );
        return icon.getImage();
    }
}
