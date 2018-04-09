import sweeper.Box;
import sweeper.Coord;
import sweeper.Game;
import sweeper.Ranges;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class JavaSweeper extends JFrame {

    private Game game;
    private JPanel mJPanel;
    private JLabel mJlabel;
    private static final int COLS = 9;
    private static final int ROWS = 9;
    private static final int BOMBS = 3;
    private static final int IMAGE_SIZE = 50;


    public static void main(String[] args) {

        new JavaSweeper();
    }

    private JavaSweeper() {
        game = new Game(COLS, ROWS, BOMBS);
        game.start();
        setImages();
        initPanel();
        initLabel();
        initFrame();
    }

    private void initLabel() {
        mJlabel = new JLabel(getMessage());
        Font font = new Font("Tahoma", Font.BOLD, 18);
        mJlabel.setFont(font);
        add(mJlabel, BorderLayout.SOUTH);
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

        // мышечный адаптер
        mJPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / IMAGE_SIZE;
                int y = e.getY() / IMAGE_SIZE;
                Coord coord = new Coord(x, y);
                switch (e.getButton()) {
                    case MouseEvent.BUTTON1:
                        game.pressLeftButton(coord);
                        break;
                    case MouseEvent.BUTTON3:
                        game.pressRightButton(coord);
                        break;
                    case MouseEvent.BUTTON2:
                        game.start();
                        break;
                }
                mJlabel.setText(getMessage());
                mJPanel.repaint();
            }
        });

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

    private String getMessage() {
        switch (game.getState()) {

            case BOMBED:
                return "Ba-da_boom!";
            case WINNER:
                return "Congratulations!";
            case PLAYED:
            default:
                if (game.getTotalFlagged() == 0) {
                    return "Welcome!";
                } else {
                    return "Think twice! Flagged " + game.getTotalFlagged() + " of " + game.getTotalBombs() + " bombs";
                }

        }
    }
}

