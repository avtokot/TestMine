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
        mJPanel = new JPanel();
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

}
