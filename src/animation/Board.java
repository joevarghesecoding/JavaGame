package animation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Board extends JPanel implements ActionListener
{
    /*
    In the Board class we move a star that from the upper-left corner
    to the right-bottom corner.

    Five constants are defined. The first two constants are the board
    width and height. The third and fourth are the initial coordinates of the star.
    The last one determines the speed of the animation.
     */
    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;
    private final int DELAY = 25;


    /*
    In the loadImage() method we create an instance of the ImageIcon class.
     */
    private Image star;
    private Timer timer;
    private int x, y;

    public Board() {

        initBoard();
    }

    /*
    The image is located in the project directory. The getImage() method will
    return the the Image object from this class. This object will be drawn on the board.
     */
    private void loadImage() {

        ImageIcon ii = new ImageIcon("src/animation/star.png");
        star = ii.getImage();
    }

    private void initBoard()
    {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        loadImage();

        x = INITIAL_X;
        y = INITIAL_Y;

        /*
        Here we create a Swing Timer class and call its start() method.
        Every DELAY ms the timer will call the actionPerformed() method.
        In order to use the actionPerformed() method, we must implement the
        ActionListener interface.
         */
        timer = new Timer(DELAY, this);
        timer.start();

    }

    /*
    Custom painting is done in the paintComponent() method. Note that we also
    call the paintComponent() method of its parent.
    The actual painting is delegated to the drawStar() method.
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        drawStar(g);
    }

    /*
    In the drawStar() method, we draw the image on the window with the usage of
    the drawImage() method. The Toolkit.getDefaultToolkit().sync() synchronises
    the painting on systems that buffer graphics events.
    Without this line, the animation might not be smooth on Linux.
     */
    private void drawStar(Graphics g)
    {
        g.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }

    /*
    The actionPerformed() method is repeatedly called by the timer. Inside the method,
    we increase the x and y values of the star object. Then we call the repaint() method
     which will cause the paintComponent() to be called. This way we regularly
     repaint the Board thus making the animation.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        x += 1;
        y += 1;

        if(y > B_HEIGHT)
        {
            y = INITIAL_Y;
            x = INITIAL_X;
        }

        repaint();
    }
}
