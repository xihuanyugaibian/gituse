package cn.feng;

import java.util.ArrayList;

public class BallFactory {
	ArrayList<Ball> balls = new ArrayList<Ball>();

	public synchronized void buildBall() {
		try {
			if (balls.size() == 1) {
				wait();
			}
			balls.add(new Ball());
			notify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized Ball getBall() {
		try {
			if (balls.size() == 0) {
				wait();
			}
			Ball ball = balls.get(0);
			if (!ball.isLive()) {
				balls.clear();
				notify();
			}
			return ball;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
