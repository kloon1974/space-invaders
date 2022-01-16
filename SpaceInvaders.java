////////////////////////////////////////////////////////////////////////////////
// Checklist:
// refresh rate counter alien
// different variable for it
////////////////////////////////////////////////////////////////////////////////
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

public class SpaceInvaders extends JPanel implements KeyListener, Runnable, MouseListener {
    // Game States
    public static boolean intro = true;
    public static boolean play = false;

    // Game Stats
    public static int posX;
    public static int posY;
    public static int posxShip = 320;
    public static int posyShip = 400;
    public static int speedFactor = 1;

    // Game Images
    public static BufferedImage alien;
    public static BufferedImage spaceship;
    public static BufferedImage alien_bullet;
    public static BufferedImage spaceship_bullet;

    // JPanel Constructor
    public SpaceInvaders()
    {
        setPreferredSize(new Dimension(1024, 768));
        setBackground(new Color(0, 0, 0));
        this.setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);
        try
        {
            spaceship = ImageIO.read(new File("spaceship.png")); // 98 x 100 px
            // spaceship_bullet = ImageIO.read(new File("spaceship_bullet.png"));
            // alien = ImageIO.read(new File("alien.png"));
            // alien_bullet = ImageIO.read(new File("alien_bullet.png"));
        }
        catch (Exception e)
        {
            System.out.println("File cannot be found");
        }
        // When using Runnable, you have to
        // create a new Thread
        Thread thread = new Thread(this);
        thread.start();
    }

    // Threading Method
    public void run()
    {
        while(true)
        {
            repaint();
            try
            {
                Thread.sleep(10); // The commands after while(true) but before try will execute once every 80 milliseconds
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }


    // KeyListener Methods
    public void keyPressed(KeyEvent e) {
        //Right Key
        if(e.getKeyCode()==39 || e.getKeyChar() == 'd') {
            System.out.println("Right");
            posxShip += 5;
            if (posxShip > 926) {
                posxShip = 926;
            }
            paintComponent(this.getGraphics());
        }
        //Left Key
        else if (e.getKeyCode()==37 || e.getKeyChar() == 'a') {
            System.out.println("Left");
            posxShip -= 5;
            if (posxShip < 0) {
                posxShip = 0;
            }
            paintComponent(this.getGraphics());
        }
        //Up Key
        else if (e.getKeyCode()==38 || e.getKeyChar() == 'w') {
            System.out.println("Up");
            posyShip -= 5;
            if (posyShip < 0) {
                posyShip = 0;
            }
            paintComponent(this.getGraphics());
        }
        //Down Key
        else if (e.getKeyCode()==40 || e.getKeyChar() == 's') {
            System.out.println("Down");
            posyShip += 5;
            if (posyShip > 668) {
                posyShip = 668;
            }
            paintComponent(this.getGraphics());
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    // MouseListener Methods
    public void mouseClicked(MouseEvent e) {
        posX = e.getX();
        posY = e.getY();
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    // PaintComponent
    public void paintComponent(Graphics g) {
        // if(play)
        // {
        //     super.paintComponent(g);
        //     g.drawImage(spaceship, posxShip, posyShip, this);
        // }
        super.paintComponent(g);
        g.drawImage(spaceship, posxShip, posyShip, this);
    }

    public static void main(String[] args) {
        // Create a frame
        JFrame myFrame = new JFrame("ALIENS ARE REAL");

        // Create a panel to put inside the frame
        SpaceInvaders myPanel = new SpaceInvaders();
        myFrame.add(myPanel);

        // Maximize your frame to the size of the panel
        myFrame.pack();

        // Set the visibility of the frame to visible
        myFrame.setVisible(true);
    }
}