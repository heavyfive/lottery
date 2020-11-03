package net.june.lottery;

import java.util.ArrayList;

public class Lottery {

    private static final int TOTAL_BALLS_COUNT = 45; // 공의 개수
    private static final int ELECTION_COUNT = 6; // 추첨할 공의 수
    private static int GAME_REPEAT_TIMES = 10; // 게임 반복 수. Default 5. 실행인자로 입력 가능

    private static final Presenter PRESENTER = new Presenter(); // 출력 디바이스

    private Sphere sphere; //

    private Lottery() {
        this.sphere = new Sphere(); // 공이 들어있는 투명 통
    }
    
    public static Lottery createInstance() {
    	return new Lottery();
    }

    public static void main(String [] args) {
        if (args.length > 0) {
            GAME_REPEAT_TIMES = Integer.valueOf(args[0]);
        }

        for (int index = 0 ; index < GAME_REPEAT_TIMES; ) { // 게임 반복
            Lottery lottery = Lottery.createInstance(); // 추첨기계
            lottery.sphere.putInBalls(TOTAL_BALLS_COUNT); // 공 채움
            ArrayList<Ball> basket = lottery.sphere.pickOutBalls(ELECTION_COUNT); // 공 추첨
            PRESENTER.presentSortedResult(basket); // 당첨번호세트 출력
            index++;
        }
    }

}
