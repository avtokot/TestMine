import javax.swing.*;
import java.awt.*;

public class JavaSweeper extends JFrame {

    private JPanel mJPanel;

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
                g.drawImage(getImage("num1"), 50, 0, this);
                g.drawImage(getImage("num1"), 50, 50, this);
                g.drawImage(getImage("num1"), 0, 50, this);
            }
        };
        mJPanel.setPreferredSize(new Dimension(500, 300));
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
