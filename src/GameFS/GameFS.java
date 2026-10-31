import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

public class GameFS {
   public static void main(String [] args ) {

        // Creating The FullScreen! ->

        JFrame wd = new JFrame();

        final int WinW = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        final int WinH = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        wd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        wd.setAlwaysOnTop(true);

        wd.setUndecorated(true);

        wd.setLayout(null);

        wd.setPreferredSize(new Dimension(WinW, WinH));

        wd.pack();

        wd.setLocationRelativeTo(null);
        wd.setTitle("SF");

        wd.getContentPane().setBackground(Color.BLACK);

        JButton CloseG = new JButton("Quit Game!");

        CloseG.setForeground(Color.YELLOW);
        CloseG.setBackground(Color.pink);

        CloseG.setBounds(WinW / 2, WinH / 2 , WinW / 7, WinH / 12);
        CloseG.setFocusPainted(false);

        CloseG.setFont(new Font("?", Font.BOLD, 58));

        CloseG.addActionListener(e -> {

            System.exit(0);
        });

        wd.add(CloseG);

        wd.setVisible(true);
   }
}
