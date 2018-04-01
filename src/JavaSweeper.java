import sweeper.Box;
import sweeper.Coord;
import sweeper.Game;
import sweeper.Ranges;

import javax.swing.*;
import java.awt.*;


public class JavaSweeper extends JFrame {

    private Game game;
    private JPanel mJPanel;
    private static final int COLS = 9;
    private static final int ROWS = 9;
    private static final int BOMBS = 10;
    private static final int IMAGE_SIZE = 50;


    public static void main(String[] args) {

        new JavaSweeper();
    }

    private JavaSweeper() {
        game = new Game(COLS, ROWS, BOMBS);
        game.start();
        setImages();
        initPanel();
        initFrame();
    }

    private void initPanel() {
        mJPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coord coord : Ranges.getAllCoords()) {
                    g.drawImage((Image) game.getBox(coord).mImage,
                            coord.x * IMAGE_SIZE, coord.y * IMAGE_SIZE, this);
                }

            }
        };
        mJPanel.setPreferredSize(new Dimension(Ranges.getSize().x * IMAGE_SIZE, Ranges.getSize().y * IMAGE_SIZE));
        add(mJPanel);
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Sweeper");
        setLocationRelativeTo(null);
        setResizable(false); // запрет на изменения размеров окна
        pack();
        setVisible(true);
    }

    private void setImages() {
        for (Box box : Box.values())
            box.mImage = getImage(box.name().toLowerCase());
        setIconImage(getImage("icon")); // установка заглавной картинки
    } // main image

    private Image getImage(String name) {
        String filename = "img/" + name + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));
        return icon.getImage();
    }
}
