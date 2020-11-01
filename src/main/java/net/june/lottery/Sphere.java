package net.june.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sphere {

	private List<Ball> balls;

	public Sphere() {
		this.balls = new ArrayList<Ball>();
	}
	
	public List<Ball> getBalls() {
		return balls;
	}

	public void putIn(Ball ball) {
		balls.add(ball);
	}
	
	public Ball pickOutBall() {
		this.shuffle();
		int index = (int)(Math.random() * balls.size());
		Ball ball = balls.get(index);
		balls.remove(index);
		
		return ball;
	}
	
	public void clear() {
		balls.clear();
	}
	
	private void shuffle() {
		Collections.shuffle(balls);
	}
}
