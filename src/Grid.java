import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.awt.*;

public class Grid extends JFrame {

    int spacing = 3;

    public int posx = -100;
    public int posy = -100;

    int[][] start = new int[1][1];
    int[][] end = new int [1][1];
    int[][] neighbors = new int[16][9];
    boolean[][] barrier = new boolean[16][9];



    public Grid(){
        this.setTitle("Pathfinding Visualizer");
        this.setSize(1286, 829);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        Visualizer visualizer = new Visualizer();
        this.setContentPane(visualizer);

        Place place = new Place();
        this.addMouseMotionListener(place);

        Click click = new Click();
        this.addMouseListener(click);
    }

    public class Visualizer extends JPanel{
        public void paintComponent(Graphics x) {
            x.setColor(Color.black);
            x.fillRect(0, 0, 1280, 800);
            for (int i = 0; i < 16; i ++) {
                for (int j = 0; j < 10; j++) {
                    x.setColor(Color.white);
                    if (posx >= spacing+i*80 && posx < spacing+i*80+80-2*spacing && posy >= spacing+j*80+80+26 && posy < spacing+j*80+26+80+80-2*spacing) {
                        x.setColor(Color.yellow);
                    }
                    x.fillRect(spacing+i*80, spacing+j*80+80, 80-2*spacing, 80-2*spacing);
                }
            }
        }
    }

    public int xBox() {
        for (int i = 0; i < 16; i ++) {
            for (int j = 0; j < 10; j++) {
                if (posx >= spacing + i * 80 && posx < spacing + i * 80 + 80 - 2 * spacing && posy >= spacing + j * 80 + 80 + 26 && posy < spacing + j * 80 + 26 + 80 + 80 - 2 * spacing) {
                    return i;
                }
            }
        }
        return -100;
    }

    public int yBox() {
        for (int i = 0; i < 16; i ++) {
            for (int j = 0; j < 10; j++) {
                if (posx >= spacing + i * 80 && posx < spacing + i * 80 + 80 - 2 * spacing && posy >= spacing + j * 80 + 80 + 26 && posy < spacing + j * 80 + 26 + 80 + 80 - 2 * spacing) {
                    return j;
                }
            }
        }
        return -100;
    }

    public class Place implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            posx = e.getX();
            posy = e.getY();
            repaint();

        }
    }
    public class Click implements MouseListener {

        @Override

        public void mouseClicked(MouseEvent e) {
            if (xBox() != -100 && yBox() != -100) {
                System.out.println("the mouse was clicked " + xBox() + " " + yBox());
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
