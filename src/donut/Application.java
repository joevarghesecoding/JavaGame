import javax.swing.*;
import java.awt.*;

//This is the entry point of the game. Here we have the main method.
public class Application extends JFrame
{
    public Application()
    {
        initUI();
    }

    private void initUI()
    {
        //Here we put the Board to the center of the JFrame container
        add(new Board());

        //This line sets the size of the window.
        setSize(800, 700);

        //This will close the application when we click on the close button. This is not the default behavior.
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Passing null to the setLocationRelativeTo() method centers the window on the screen.
        setLocationRelativeTo(null);
    }

    //We create an instance of our code example and make it visible on the screen
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
    }
}
