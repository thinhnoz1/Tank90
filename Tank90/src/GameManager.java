import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class GameManager {

    int[][] map = {
            {0,0,4,4,4,4,4,4,4,4,4,4,0,0,4,4,4,4,4,4,4,4,4,4,0,0},
            {0,0,4,4,4,4,4,4,4,4,4,4,0,0,4,4,4,4,4,4,4,4,4,4,0,0},
            {0,0,4,4,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,4,4,0,0},
            {0,0,4,4,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,4,4,0,0},
            {0,0,4,4,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,4,4,0,0},
            {0,0,4,4,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,4,4,0,0},
            {0,0,4,4,0,0,1,1,1,1,1,1,0,0,1,1,0,0,1,1,0,0,4,4,0,0},
            {0,0,4,4,0,0,1,1,1,1,1,1,0,0,1,1,0,0,1,1,0,0,4,4,0,0},
            {1,1,4,4,0,0,0,0,0,0,1,1,0,0,1,1,0,0,1,1,0,0,4,4,1,1},
            {1,1,4,4,0,0,0,0,0,0,1,1,0,0,1,1,0,0,1,1,0,0,4,4,1,1},
            {1,1,4,4,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,4,4,1,1},
            {1,1,4,4,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,4,4,1,1},
            {1,1,4,4,4,4,4,4,2,2,2,2,2,2,2,2,2,2,4,4,4,4,4,4,1,1},
            {1,1,4,4,4,4,4,4,2,2,2,2,2,2,2,2,2,2,4,4,4,4,4,4,1,1},
            {5,5,0,0,0,0,0,0,0,0,0,0,5,5,0,0,0,0,0,0,0,0,0,0,5,5},
            {5,5,0,0,0,0,0,0,0,0,1,1,5,5,1,1,0,0,0,0,0,0,0,0,5,5},
            {2,2,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,2,2},
            {2,2,1,1,0,0,1,1,0,0,1,1,1,1,1,1,0,0,1,1,0,0,1,1,2,2},
            {2,2,1,1,5,5,1,1,5,5,1,1,1,1,1,1,5,5,1,1,5,5,1,1,2,2},
            {2,2,1,1,5,5,1,1,5,5,1,1,1,1,1,1,5,5,1,1,5,5,1,1,2,2},
            {2,2,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,2,2},
            {2,2,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,2,2},
            {2,2,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,2,2},
            {2,2,1,1,0,0,1,1,0,0,0,1,1,1,1,0,0,0,1,1,0,0,1,1,2,2},
            {1,1,0,0,2,2,0,0,0,0,0,1,3,0,1,0,0,0,0,0,2,2,0,0,1,1},
            {1,1,0,0,2,2,0,0,0,0,0,1,0,0,1,0,0,0,0,0,2,2,0,0,1,1}
    };

    ArrayList<Map> maps;
    Player player;
    ArrayList<Boss> bosses;
    ArrayList<Bullet> bulletsPlayer;
    ArrayList<Bullet> bulletsBoss;
    int counter = 0;
    int goal;
    Random rd = new Random();

    void initGame() {
        bulletsBoss = new ArrayList<>();
        bulletsPlayer = new ArrayList<>();
        player = new Player(200, 400);
        bosses = new ArrayList<>();
        goal = 3;
        initBoss();
        readMap();
        SoundLoader.play("enter_game.wav");
    }

    void readMap() {
        maps = new ArrayList<>();
        for (int j = 0; j < map.length; j++) {
            for (int i = 0; i < map[j].length; i++) {
                if (map[j][i] > 0) {
                    int x = i * 19;
                    int y = j * 19;
                    Map m = new Map(x, y, map[j][i]);
                    maps.add(m);
                }
            }
        }
    }

    void initBoss() {
        Boss b = new Boss(0,0);
        bosses.add(b);
        b = new Boss(TankFrame.W / 2 - 19, 0);
        bosses.add(b);
        b = new Boss(TankFrame.W - 48, 0);
        bosses.add(b);
    }

    void initBoss1() {
        if (counter == 0){
            Boss b = new Boss(0,0);
            bosses.add(b);
            counter=1;
        }
        else if (counter == 1){
            Boss b = new Boss(TankFrame.W / 2 - 19, 0);
            bosses.add(b);
            counter=2;
        }
        else if (counter == 2){
            Boss b = new Boss(TankFrame.W - 48, 0);
            bosses.add(b);
            counter = 0;
        }

    }


    void draw(Graphics2D g2d) {
        for (Bullet b: bulletsPlayer) {
            b.draw(g2d);
        }
        for (Bullet b: bulletsBoss) {
            b.draw(g2d);
        }
        player.draw(g2d);
        for (Boss b: bosses) {
            b.draw(g2d);
        }
        for (Map m: maps) {
            m.draw(g2d);
        }
    }

    void playerMove(int newOrient) {
        player.orient = newOrient;
        player.move(maps);
    }

    boolean AI() {
        for (int i = bosses.size() - 1; i >= 0; i--) {
            bosses.get(i).createOrient();
            bosses.get(i).move(maps);
            int percent = rd.nextInt(101);
            if (percent >= 95) {
                bosses.get(i).fire(bulletsBoss);
            }
            boolean die = bosses.get(i).checkDie(bulletsPlayer);
            if (die && goal >0) {
                bosses.remove(i);

                if (bosses.size() <= 2) {
                    initBoss1();
                    goal--;
                }
            }
        }
        return player.checkDie(bulletsBoss)
                || moveBullet(bulletsBoss)
                || moveBullet(bulletsPlayer);
    }

    boolean moveBullet(ArrayList<Bullet> bullets) {
        for (int i = bullets.size() - 1; i >= 0; i--) {
            boolean out = bullets.get(i).move();
            if (out == true) {
                bullets.remove(i);
                continue;
            }
            for (Map m: maps) {
                if (m.bit == 4 || m.bit == 2) {
                    continue;
                }
                Rectangle rect = m.getRect().intersection(bullets.get(i).getRect());
                if (rect.isEmpty() == false) {
                    SoundLoader.play("explosion.wav");
                    bullets.remove(i);
                    if (m.bit != 5) {
                        maps.remove(m);
                    }
                    if (m.bit == 3) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }
}
