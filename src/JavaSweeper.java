import sweeper.Box;
import javax.swing.*;
import java.awt.*;


public class JavaSweeper extends JFrame {

    private JPanel mJPanel;
    private static final int IMAGE_SIZE = 50;
    private static final int COLS = 15;
    private static final int ROWS = 1;


    public static void main(String[] args) {

        new JavaSweeper();
    }

    private JavaSweeper() {
        initPanel();
        initFrame();
    }

    private void initPanel() {
        mJPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (Box box : Box.values())
                    g.drawImage(getImage(box.name().toLowerCase()), box.ordinal() * IMAGE_SIZE, 0, this);

            }
        };
        mJPanel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE));
        add(mJPanel);
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Sweeper");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false); // запрет на изменения размеров окна
        pack();
    }

    private Image getImage(String name) {
        ImageIcon icon = new ImageIcon("res/sapper/" + name + ".png");
        return icon.getImage();
    }
}
