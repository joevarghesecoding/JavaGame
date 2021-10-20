package spaceship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class SpaceShip extends Sprite
{
    private int dx;
    private int dy;
    private static int x = 40;
    private static int y = 60;
    private int w;
    private int h;
    private Image image;
    private List<Missile> missiles;

    public SpaceShip()
    {
        super(x,y);

        loadImage();
    }

    private void loadImage()
    {
        ImageIcon ii = new ImageIcon("src/resources/spaceship.png");
        image = ii.getImage();

        w = image.getWidth(null);
        h = image.getHeight(null);
    }

    /**
     * The move() method changes the coordinates of the sprite. These x and y
     * values are used in the paintComponent() method to draw the image of the sprite.
     */

    public void move() {
        x += dx;
        y += dy;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getWidth()
    {
        return w;
    }

    public int getHeight()
    {
        return h;
    }

    public Image getImage(){
        return image;
    }

    /**
     * This class represents a spaceship. In this class we keep the image of
     * the sprite and the coordinates of the sprite. The keyPressed() and keyReleased()
     * methods control whether the sprite is moving.
     */
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if(key == KeyEvent.VK_RIGHT){
            dx = 2;
        }

        if(key == KeyEvent.VK_UP){
            dy = -2;
        }

        if(key == KeyEvent.VK_DOWN){
            dy = 2;
        }
    }

    /**
     * When we release the left cursor key, we set the dx variable to zero.
     * The spacecraft will stop moving.
     */
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT){
            dx = 0;
        }

        if(key == KeyEvent.VK_RIGHT)
        {
            dx = 0;
        }
        if(key == KeyEvent.VK_UP){

            dy = 0;
        }

        if(key == KeyEvent.VK_DOWN){
            dy = 0;
        }
    }
}
