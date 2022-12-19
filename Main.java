import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class Main extends JPanel {
	private BufferedImage img = null;
	private Spaceship s = new Spaceship(550, 450, 0, 0); 
	private Asteroid a = new Asteroid(this, 0, 0, 1, 1); 
	
	Asteroid[] list = new Asteroid[3];
	
	public Main() {
		for (int i = 0; i< list.length; i++) {
			list[i] = new Asteroid(this, i*50, i*50,
			(int)(10 * Math.random() - 5),
			(int)(10 * Math.random() - 5));
		}
		
		try {
			img = ImageIO.read(new File("U:\\Documents\\Inventor\\SpaceInvaders\\src\\Images\\Background.png"));
		} catch (IOException e) {
			System.out.println("No Image");
		}
		addKeyListener(new KeyListener() {
			 @Override
			 public void keyTyped(KeyEvent e) {
			 }
			 @Override
			 public void keyReleased(KeyEvent e) {
			 s.keyReleased(e);
			 }
			 @Override
			 public void keyPressed(KeyEvent e) {
			 s.keyPressed(e);
			 }});
			 setFocusable(true);
	}

	
	private void move() {
		//Check for collisions between each of the asteroids
		for (int i = 0; i < list.length; i++) {
			for (int j = i+1; j<list.length; j++) {
				list[i].collision(list[j]);
			}
		}
		for (Asteroid a:list)
			a.move();
		
		s.moveSingle();
	}	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g); // Clears the panel, for a fresh start
		Graphics2D g2d = (Graphics2D) g;
		// Smooth’s out the movement
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.drawImage(img, 0, 0, null);
		s.paint(g2d);
		
		for (Asteroid a:list)
			a.paint(g2d);
		
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Space Invaders");
		Main m = new Main();
		frame.add(m);
		frame.setSize(1280, 720);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		while (true) {
			m.move(); // Updates the coordinates
			m.repaint(); // Calls the paint method
			Thread.sleep(10); // Pauses for a moment
		}
	}
}
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class Bullets {
	private boolean[][] alive = new boolean[5][6];
	private int xa;
	private Main m;
	private int a, b, col, row,r;
	private BufferedImage img = null;
	private static final int DIAMETER = 30;

	public Bullets(int a, int b, Main m, int x) {
		this.a = a;
		this.b = b;
		this.m = m;
		this.xa = x;
		try {
			img = ImageIO.read(new File("C:\\\\Users\\\\s300041935\\\\eclipse-workspace\\\\RealProject\\\\src\\\\Laser.png"));
		} catch (IOException e) {
			System.out.println("No Image");
		}
	}
	public int getY() {
		return this.b;
	}
	public int getX() {
		return this.a;
	}
	public void setY(int b) {
		this.b = b;
	}
	public void setX(int b) {
		this.a = b;
	}
	public int getRow() {
		return this.row;
	}
	public int getCol() {
		return this.col;
	}
	void move() {
		b = b + xa;
	}

	public void paint(Graphics g) {
		Graphics g2d = g;
		g.drawImage(img, a, b, null);
	}

}
