package net.june.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Presenter {
	
	private int presentCount;

    private void presentResult(List<Integer> ballLabels) {
        int labelSize = ballLabels.size();
        StringBuffer ballSet = new StringBuffer();
        for (int idx = 0 ; idx < labelSize ; idx++) {
            if(ballSet.length() > 0) {
                ballSet.append(", ");
            }
            int ballLabel = ballLabels.get(idx);
            String preLabel = ballLabel < 10 ? "0" : "";
            ballSet.append(preLabel + ballLabels.get(idx));
        }
        System.out.println(++presentCount + "번째 추첨번호 : " + ballSet + "\n");
    }

    public void presentSortedResult(ArrayList<Ball> basket) {
        ArrayList<Integer> ballLabels = new ArrayList<Integer>();
        for (Ball ball : basket) {
            ballLabels.add(Integer.valueOf(ball.getLabel()));
        }
        Collections.sort(ballLabels);
        presentResult(ballLabels);
    }
}
