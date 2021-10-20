package animation;

import javax.swing.*;
import java.awt.*;

public class UtilityTimerEx extends JFrame
{
    public UtilityTimerEx() {

        initUI();
    }

    private void initUI() {

        add(new UtilityBoard());

        setResizable(false);
        pack();

        setTitle("Star");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        /*
        Using threads to animate objects is the most effective and
        accurate way of animation
         */

        EventQueue.invokeLater(() -> {
            JFrame ex = new UtilityTimerEx();
            ex.setVisible(true);
        });

    }
}
