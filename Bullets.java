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
