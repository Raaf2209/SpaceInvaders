import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class Spaceship {
    private int x;
    private int y;
    private int xa;
    private int ya;
    private BufferedImage spaceship = null;
    private BufferedImage spaceshipExhaust = null;
    private BufferedImage spaceshipBack = null;   
    private BufferedImage spaceshipLeft = null;
    private BufferedImage spaceshipRight = null;    

    private boolean right = false, left = false;
    private Boolean up = false, down = false;
    private boolean space = false;
    private int counter = 1;

    public Spaceship(int x, int y, int xa, int ya) {
        try {
            spaceship = ImageIO.read(new File("U:\\Documents\\Inventor\\SpaceInvaders\\src\\Images\\SpaceshipDefault.png"));
            spaceshipExhaust = ImageIO.read(new File("U:\\Documents\\Inventor\\SpaceInvaders\\src\\Images\\SpaceshipExhaust.png"));
            spaceshipBack = ImageIO.read(new File("U:\\Documents\\Inventor\\SpaceInvaders\\src\\Images\\SpaceshipBack.png"));
            spaceshipLeft = ImageIO.read(new File("U:\\Documents\\Inventor\\SpaceInvaders\\src\\Images\\SpaceshipLeft.png"));
            spaceshipRight = ImageIO.read(new File("U:\\Documents\\Inventor\\SpaceInvaders\\src\\Images\\SpaceshipRight.png"));
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

    public boolean getUp() {
        return up;
    }
    public boolean getDown() {
        return down;
    }
    public boolean getLeft() {
        return left;
    }
    public boolean getRight() {
        return right;
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
        if (getUp() == true) {
            g.drawImage(spaceshipExhaust, getX(), getY(), null);
        }
        else if (getDown() == true) {
            g.drawImage(spaceshipBack, getX(), getY(), null);       	
        }
        else if (getLeft() == true) {
            g.drawImage(spaceshipLeft, getX(), getY(), null);       	
        }
        else if (getRight() == true) {
            g.drawImage(spaceshipRight, getX(), getY(), null);       	
        }
        else {
            g.drawImage(spaceship, getX(), getY(), null);
        }
        
        if (getSpace() == true) {
            g.setColor(new Color(255, 0, 0, 225)); 
        	if (counter == -1) {
                counter = counter*-1;
                g.fillRoundRect(getX()+65, getY()+40, 10, 40, 5, 10);
        	}
        	else if (counter == 1) {
                counter = counter*-1;
        		g.fillRoundRect(getX()+75+50, getY()+40, 10, 40, 5, 10);    
        	}
        }
    }
}
