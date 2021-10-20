package spaceship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener
{
   private Timer timer;
   private SpaceShip spaceShip;
   private final int DELAY = 10;

   public Board(){
       initBoard();
   }

    private void initBoard() {

       addKeyListener(new TAdapter());
       setBackground(Color.BLACK);
       setFocusable(true);

       spaceShip = new SpaceShip();

       timer = new Timer(DELAY, this);
       timer.start();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * In the doDrawing() method, we draw the spaceship with the
     * drawImage() method. We get the image and the coordinates from the sprite class.
     */

    private void doDrawing(Graphics g) {
       Graphics2D g2d = (Graphics2D) g;

       g2d.drawImage(spaceShip.getImage(), spaceShip.getX(),
               spaceShip.getY(), this);
    }

    /**
     * The actionPerformed() method is called every DELAY ms. We call the step() method.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        step();
    }

    /**
     * We move the sprite and repaint the part of the board that has changed.
     * We use a small optimisation technique that repaints only the small area
     * of the window that actually changed
     */
    private void step() {

       spaceShip.move();

       repaint(spaceShip.getX()-1, spaceShip.getY()-1,
               spaceShip.getWidth()+2, spaceShip.getHeight()+2);

    }

    /**    In the Board class we listen for key events. The overridden methods of the
     *   KeyAdapter class delegate the processing to the methods of the Craft class.
     */
    private class TAdapter extends KeyAdapter {
       @Override
        public void keyReleased(KeyEvent e){
           spaceShip.keyReleased(e);
       }

       @Override
        public void keyPressed(KeyEvent e){
           spaceShip.keyPressed(e);
       }
    }
}
