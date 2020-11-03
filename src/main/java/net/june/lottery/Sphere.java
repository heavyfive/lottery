package net.june.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sphere {

	private List<Ball> balls;
	private final List<Ball> basket;

	public Sphere() {
		this.balls = new ArrayList<Ball>();
		this.basket = new ArrayList<Ball>(); // 추첨된 공 보관 장소
	}

	/**
	 * 공 채움
	 * @param totalBallCount
	 */
	void putInBalls(int totalBallCount) {
		int ballLabel = 1;
		while(ballLabel <= totalBallCount) {
			Ball ball = new Ball(ballLabel);
			balls.add(ball);
			ballLabel++;
		}
	}

	/**
	 * 공 추첨
	 * @param electionCount
	 * @return
	 */
	public ArrayList<Ball> pickOutBalls(int electionCount) {
		while(this.basket.size() < electionCount) {
			this.basket.add(pickOutBall());
		}

		return (ArrayList<Ball>) this.basket;
	}

	private Ball pickOutBall() {
		this.shuffle();
		int index = (int)(Math.random() * balls.size());
		Ball ball = balls.get(index);
		balls.remove(index);
		
		return ball;
	}

	private void shuffle() {
		Collections.shuffle(balls);
	}
}
