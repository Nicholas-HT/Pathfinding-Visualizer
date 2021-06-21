import javax.swing.*;
import java.awt.*;

public class EntryScreen {

    public EntryScreen() {
        JFrame frame = new JFrame();

        JButton star_button = new JButton("Begin");


        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 200, 200));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(star_button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Pathfinding Visualizer");
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        new Grid();

    }
}
