package cn.feng;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import org.omg.Messaging.SyncScopeHelper;

public class Ball {
	// 调试文件
	private int x;
	private int y;
	private Color color;
	private boolean live;

	public Ball() {
		super();
		Random random = new Random();
		x = random.nextInt(10) * 80;
		y = random.nextInt(10) * 60;
		color = Color.green;
		live = true;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, 10, 10);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

}
