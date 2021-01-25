import java.awt.*;

public class Map {
    int x;
    int y;
    int bit;
    Image[] images = {
            ImageLoader.getImage("brick.png"),
            ImageLoader.getImage("water.png"),
            ImageLoader.getImage("bird.png"),
            ImageLoader.getImage("tree.png"),
            ImageLoader.getImage("rock.png"),
    };

    public Map(int x, int y, int bit) {
        this.x = x;
        this.y = y;
        this.bit = bit;
    }

    void draw(Graphics2D g2d) {
        if (bit == 3) {     // Ve nv tuong' dong` minh
            g2d.drawImage(images[bit - 1], x, y,
                    38, 38, null);
        } else {
            g2d.drawImage(images[bit - 1], x, y, null);
        }
    }

    Rectangle getRect() {
        int w = images[bit - 1].getWidth(null);
        int h = images[bit - 1].getHeight(null);
        if (bit == 3) {     //  Scale lai nv tuong' dong` minh (phan Ve o tren)
            w = 38;
            h = 38;
        }
        Rectangle rect = new Rectangle(x, y, w, h);
        return rect;
    }
}
