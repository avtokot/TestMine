import javax.swing.*;
import java.awt.*;

public class JavaSweeper extends JFrame {

    JPanel mJPanel;

    public static void main(String[] args) {

        new JavaSweeper();
    }

    public JavaSweeper() {

        mJPanel = new JPanel();
        mJPanel.setPreferredSize(new Dimension(500, 300));
        add(mJPanel);
        pack();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Sweeper");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false); // запрет на изменения размеров окна
    }
}
