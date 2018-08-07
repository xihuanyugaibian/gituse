package cn.snake.feng;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

/**
 * Snake的框架启动
 * 
 * @author 冯永康
 *
 */
public class Main {
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setSize(800, 600);
		final Ui ui = new Ui();
		jFrame.add(ui);
		jFrame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				int a = e.getKeyCode();
				ui.keyPressed(a);
			}
		});
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
		
	}

}
