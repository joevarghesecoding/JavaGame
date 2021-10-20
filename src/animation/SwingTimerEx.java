package animation;

import animation.Board;

import javax.swing.*;
import java.awt.EventQueue;


public class SwingTimerEx extends JFrame
{
    public SwingTimerEx()
    {
        initUI();
    }

    private void initUI() {
        add(new Board());

        /*
        The setResizable() sets whether the frame can be resized
         */
        setResizable(false);
        /*
        The pack() method causes this window to be sized to fit the preferred
        size and layouts of its children

        The order of these two matters.

        On some systems the changes would be different if not ordered correctly.
         */
        pack();

        setTitle("Star");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(()-> {
            SwingTimerEx ex = new SwingTimerEx();
            ex.setVisible(true);
        });
    }
}
