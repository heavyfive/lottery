package net.june.lottery;

import java.util.ArrayList;
import java.util.List;

public class Lottery {

    private static final int TOTAL_NUMBER_OF_BALLS = 45;
    private static final int ELECT_NUMBER_OF_BALLS = 6;
    private static int REPEAT_TIMES_OF_GAME = 5;
	private static int ENOUGH_COUNT = 1;
    private static final Printer PRINTER = new Printer();

    private Sphere sphere;
    private List<Ball> basket;

    private Lottery() {
        this.sphere = new Sphere();
        this.basket = new ArrayList<Ball>();
    }
    
    public static Lottery createInstance() {
    	return new Lottery();
    }

    public static void main(String [] args) {
        if (args.length > 0) {
            REPEAT_TIMES_OF_GAME = Integer.valueOf(args[0]);
        }

        for (int index = 0 ; index < REPEAT_TIMES_OF_GAME  ; ) {
        	// 기록노트는 게임마다 1개씩 생성
            CounterNote counterNote = new CounterNote(TOTAL_NUMBER_OF_BALLS);
            
            INNERWHILE:
            while(true) {
            	// 추첨기계는 세트마다 1개씩 생성
                Lottery lottery = Lottery.createInstance();
                // 공 채워넣기
                lottery.putInBalls();
                // 공 추첨하기
                lottery.pickOutBalls();
                // 당첨번호 리스트에 저장
                if (counterNote.hasEnoughSet(lottery.basket, ENOUGH_COUNT )) {
                    // 당첨된 번호세트 기록
                    counterNote.addElectedCount(lottery.basket);
                    // 당첨된 번호세트 오름차순정렬로 가져오기
                    List<Integer> finalLabels = counterNote.getFinalLabels(ELECT_NUMBER_OF_BALLS);
                    // 당첨된 번호세트 출력
                    PRINTER.printStatisticResult(finalLabels);
                    
                    break INNERWHILE;
                } else {
                    counterNote.addElectedNumbersSet(lottery.basket);
                }
            }
            
            index++;
        }
    }

    private void putInBalls() {
        int ballLabel = 1;
        while(ballLabel <= TOTAL_NUMBER_OF_BALLS) {
            Ball ball = new Ball(ballLabel);
            this.sphere.putIn(ball);
            ballLabel++;
        }
    }

    private void pickOutBalls() {
        while(this.basket.size() < ELECT_NUMBER_OF_BALLS) {
            this.basket.add(this.sphere.pickOutBall());
        }
    }
}
