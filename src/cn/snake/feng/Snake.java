package cn.snake.feng;

import java.awt.Color;
import java.awt.Graphics;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Snake {
	private int x;
	private int y;
	private boolean move, live;
	private Dir dir;

	ArrayList<Snode> snodes = new ArrayList<Snode>();

	public Snake() {
		super();
		snodes.add(new Snode(200, 200));
		move = true;
		live = true;
		dir = Dir.RiGHT;
	}

	public void move() {
		switch (dir) {
		case UP:
			y -= 10;
			break;
		case DOWN:
			y += 10;
			break;
		case LEFT:
			x -= 10;
			break;
		case RiGHT:
			x += 10;
			break;
		default:
			break;
		}
		for (int i = snodes.size() - 1; i > 0; i--) {
			snodes.get(i).setX(snodes.get(i - 1).getX());
			snodes.get(i).setY(snodes.get(i - 1).getY());
		}
		snodes.get(0).setX(x);
		snodes.get(0).setY(y);
		if (x == -10 || x == 790 || y == -10 || y == 560) {
			JOptionPane.showMessageDialog(null, "撞墙");
//			new PrintStream(Logger.info("撞墙"));
			Logger.info("撞墙\t\n");
//			System.out.println("nihao");
			move = false;
		}

	}

	public void eat(Ball ball) {
		ball.setLive(false);
		snodes.add(new Snode(x, y));// 重合的时候吃掉小球,即集合新建一个小球处的snode添加进去.
	}

	public void draw(Graphics g) {
		g.setColor(Color.cyan);
		for (int i = 0; i < snodes.size(); i++) {
			g.fillOval(snodes.get(i).getX(), snodes.get(i).getY(), 10, 10);
		}
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

	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

}
