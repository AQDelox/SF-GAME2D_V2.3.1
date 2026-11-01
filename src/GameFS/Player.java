package GameFS;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;

public class Player {

    public BufferedImage PlayerImg;
    public boolean UPpressed, Downpressed, leftPressed, rightPressed;

    final int PlayerLocationX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    final int PlayerLocationY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public int playerX = PlayerLocationX -500, playerY = PlayerLocationY -500;

    public int playerSize = 128;

    public int playerSpeed = 5;

    

}
