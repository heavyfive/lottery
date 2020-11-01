package net.june.lottery;

import java.util.List;

public class Printer {
	
	private int printCount;

    public void printStatisticResult(List<Integer> finalLabels) {

        int labelSize = finalLabels.size();
        StringBuffer ballSet = new StringBuffer();

        for (int index = 0 ; index < labelSize ; index++) {

            String preLabel = "";

            if (finalLabels.get(index) < 10) {
                preLabel = "0";
            }

            if(ballSet.length() > 0) {
                ballSet.append(", ");
            }

            ballSet.append(preLabel + finalLabels.get(index));
        }

        System.out.println(++printCount + "번째 추첨번호 : " + ballSet + "\n");
    }

}
