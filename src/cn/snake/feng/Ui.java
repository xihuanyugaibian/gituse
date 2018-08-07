package cn.snake.feng;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Ui extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Snake snake;
	private Ball ball;
	private BallFactory ballFactory = new BallFactory();

	public Ui() {
		super();
		this.setSize(800, 600);
		this.setBackground(Color.lightGray);
		snake = new Snake();
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {
						Thread.sleep(5);
						while (snake.isMove()) {
							Thread.sleep(200);
							snake.move();
							repaint();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					ballFactory.buildBall();
				}
			}
		}).start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ball = ballFactory.getBall();
		ball.draw(g);
		snake.draw(g);
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (snake.getX() == ball.getX() && snake.getY() == ball.getY()) {
			snake.eat(ball);
		}
		/* Begin:冯永康 2018-8-6 1282230766 addReason:增加功能 */
		for (int i = 2; i < snake.snodes.size(); i++) {
			if (snake.snodes.get(1).getX() == snake.snodes.get(i).getX()
					&& snake.snodes.get(1).getY() == snake.snodes.get(i).getY()) {
				snake.setLive(false);
				System.exit(0);
			}
		}
		/* End:冯永康 2018-8-6 1282230766 addReason:增加功能 */
	}

	public void keyPressed(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_UP:
			snake.setDir(Dir.UP);
			break;
		case KeyEvent.VK_DOWN:
			snake.setDir(Dir.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			snake.setDir(Dir.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			snake.setDir(Dir.RiGHT);
			break;
		case KeyEvent.VK_SPACE:
			snake.setMove(snake.isMove() ? false : true);
			break;
		}
		snake.move();
	}

}
