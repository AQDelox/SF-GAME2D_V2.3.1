import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, KeyListener{

    Thread gameThread;

    final int FPS = 120;

    public GamePanel() {

        this.setBackground(Color.BLACK);

        
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


    }

    public void paintComponent() {


    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }



}
