import javax.swing.*;
import java.awt.*;

public class BoardBGimg extends JPanel
{
    private Image psu;

    public BoardBGimg()
    {
        initBoard();
    }

    private void initBoard()
    {
        loadImage();

        /*
        We determine the width and height of the image. The preferred size of the board panel is set to the
        dimensions of the image. In cooperation with JFrame's pack() method, the window is just big enough
        to show the image.
         */
        int w = psu.getWidth(this);
        int h = psu.getHeight(this);
        setPreferredSize(new Dimension(w,h));
    }

    private void loadImage()
    {
        //We paint a psu image on the board. The image is drawn inside the paintComponent() method

        //We crate an ImageIcon
        ImageIcon ii = new ImageIcon("src/download.png");

        //We get an Image out of the ImageIcon
        psu = ii.getImage();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        //We draw the image on the window
        g.drawImage(psu, 0, 0, null);
    }


}
