package animation;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class UtilityBoard extends JPanel implements Runnable
{
    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;
    private final int DELAY = 25;

    private Image star;
    private Timer timer;
    private int x, y;
    private Thread animator;

    public UtilityBoard() {

        initBoard();
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("src/animation/star.png");
        star = ii.getImage();
    }

    private void initBoard() {

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        loadImage();

        x = INITIAL_X;
        y = INITIAL_Y;

        /*
        In this example, the timer will regularly call the run() method
        of the ScheduleTask class.
         */
//        timer = new Timer();
//        timer.scheduleAtFixedRate(new ScheduleTask(),
//                INITIAL_DELAY, PERIOD_INTERVAL);
    }

    //USING THREADS
    /*
    The addNotify() method is called after our JPanel has been added to the
    JFrame component. This method is often used for various initialisation tasks.
     */
    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawStar(g);
    }

    private void drawStar(Graphics g) {

        g.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }

//    private class ScheduleTask extends TimerTask {
//
//        @Override
//        public void run() {
//
//            x += 1;
//            y += 1;
//
//            if (y > B_HEIGHT) {
//                y = INITIAL_Y;
//                x = INITIAL_X;
//            }
//
//            repaint();
//        }

    //USING THREADS

    private void cycle() {

        x += 1;
        y += 1;

        if (y > B_HEIGHT) {

            y = INITIAL_Y;
            x = INITIAL_X;
        }
    }

    /*
    In this example, the animation will take place inside a thread.
    The run() method is called only once. This is why why we have a
     while loop in the method. From this method, we call the cycle()
     and the repaint() methods.
     */
    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {

            cycle();
            repaint();

            /*
            We want our game run smoothly, at constant speed.
            Therefore we compute the system time.
             */
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {

                String msg = String.format("Thread interrupted: %s", e.getMessage());

                JOptionPane.showMessageDialog(this, msg, "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            beforeTime = System.currentTimeMillis();
        }
    }
}

