package GameFS;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, KeyListener{

    Thread gameThread;

    Player player = new Player();

    final int FPS = 120;

    public GamePanel() {

        this.setBackground(Color.BLACK);

        this.LoadImages();

        this.setFocusable(true);

        this.addKeyListener(this);
        
        

        
    }

    public void LoadImages() {

        try {

             player.PlayerImg = ImageIO.read(getClass().getResourceAsStream("/resources/down1.png"));
            
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("PLAYER IMAGE IS MISSING!");
        }

       


    }

    // The Gameloop: ->

    public void run() {

        double delta = 0;
        long CurrentTime;
        long lastTime = System.nanoTime();
        double drawInterval = 1000_000_000.0 / FPS;
        
        while (gameThread != null) {

            CurrentTime = System.nanoTime();

            delta += (CurrentTime - lastTime) / drawInterval;

            lastTime = CurrentTime;

            if (delta >= 1) {

                //System.out.println("THE GAMELOOP IS RUNNING!");

                update();
                repaint();

                delta--;

                
            }



        }

    }

    public void StartGameThread() {

        gameThread = new Thread(this);

        gameThread.start();
    }

    public void update() {

        if (player.UPpressed) {

            player.playerY -= player.playerSpeed;
        }

        if (player.Downpressed) {

            player.playerY += player.playerSpeed;
        }

        if (player.leftPressed) {

            player.playerX -= player.playerSpeed;
        }

        if (player.rightPressed) {

            player.playerX += player.playerSpeed;
        }




    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.YELLOW);

        //g.drawImage(player.PlayerImg, player.playerX, player.playerY, player.playerSize, player.playerSize, null);
        g.fillRect(player.playerX, player.playerY, player.playerSize, player.playerSize);
        

       


    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) player.UPpressed = true;
        if (code == KeyEvent.VK_A) player.leftPressed = true;
        if (code == KeyEvent.VK_S) player.Downpressed = true;
        if (code == KeyEvent.VK_D) player.rightPressed = true;
        
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) player.UPpressed = false;
        if (code == KeyEvent.VK_A) player.leftPressed = false;
        if (code == KeyEvent.VK_S) player.Downpressed = false;
        if (code == KeyEvent.VK_D) player.rightPressed = false;
        
    }



}
