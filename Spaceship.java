import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class Spaceship {
    private int x = 20;
    private int y = 20;
    private int xa = 1; // Horizontal speed
    private int ya = 1; // Vertical speed
    private BufferedImage spaceship = null;
    private BufferedImage spaceshipExhaust = null;   

    private boolean right = false, left = false;
    private Boolean up = false, down = false;
    private boolean space = false;
    private int counter = 1;

    public Spaceship(int x, int y, int xa, int ya) {
        try {
            spaceship = ImageIO.read(new File("U:\\Documents\\Inventor\\SpaceInvaders\\src\\spaceship.png"));
            spaceshipExhaust = ImageIO.read(new File("U:\\Documents\\Inventor\\SpaceInvaders\\src\\spaceshipExhaust.png"));
        } catch (IOException e) {
            System.out.println("No Image");
        }

        this.x = x;
        this.y = y;
        this.xa = xa;
        this.ya = ya;
    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            space = true;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getSpace() {
        return space;
    }

    public boolean getForward() {
        return up;
    }

    public void keyReleased(KeyEvent e) {
        // When the key is released, set the Boolean to false, and change
        // acceleration to 0
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
            xa = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
            xa = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = false;
            ya = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = false;
            ya = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            space = false;
        }
    }

    public void move() {

    }

    public void moveSingle() {
        if (right) {
            xa = 3;
        }
        if (left) {
            xa = -3;
        }
        if (down) {
            ya = 3;
        }
        if (up) {
            ya = -3;
        }
        x += xa;
        y+=ya;
    }

    public void paint(Graphics2D g) {
        //If spaceship is moving forward add exhaust trail
        if (getForward() == true) {
            g.drawImage(spaceshipExhaust, x, y, null);
        }
        else {
            g.drawImage(spaceship, x, y, null);
        }
        
        if (getSpace() == true) {
            g.setColor(new Color(255, 0, 0, 225)); 
        	if (counter == -1) {
                counter = counter*-1;
                g.fillRoundRect(x+88, y+10, 10, 50, 5, 10);
        	}
        	else if (counter == 1) {
                counter = counter*-1;
        		g.fillRoundRect(x+88+60, y+10, 10, 50, 5, 10);    
        	}
        }
    }
}
