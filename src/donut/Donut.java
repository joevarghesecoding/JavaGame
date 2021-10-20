import javax.swing.*;
import java.awt.*;

public class Donut extends JFrame
{
    public Donut() {
        initUI();
    }

    private void initUI()
    {
        add(new Board());
        setSize(330, 330);
        setTitle("Donut");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Donut donut = new Donut();
            donut.setVisible(true);
        });
    }
}
