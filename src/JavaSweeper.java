import javax.swing.*;
import java.awt.*;

public class JavaSweeper extends JFrame {

    private JPanel mJPanel;
    private static final int IMAGE_SIZE = 50;
    private static final int COLS = 15;
    private static final int ROW = 1;


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
                g.drawImage(getImage("bomb"), 0, 0, this);
                g.drawImage(getImage("num1"), IMAGE_SIZE, 0, this);
               /* g.drawImage(getImage("num1"), IMAGE_SIZE, IMAGE_SIZE, this);
                g.drawImage(getImage("num1"), 0, IMAGE_SIZE, this);*/
            }
        };
        mJPanel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE, ROW * IMAGE_SIZE));
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
