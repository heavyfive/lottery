package net.june.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CounterNote {

    private HashMap<Integer, Integer> counterMap;
    private List<Integer> ballLabels;
    private List<Set<String>> electedNumbersSetList;

    public CounterNote(int totalSize) {
        this.counterMap = new HashMap<Integer, Integer>();
        this.ballLabels = new ArrayList<Integer>();
        this.electedNumbersSetList = new ArrayList<Set<String>>();
        prepareCounter(totalSize);
    }

    @SuppressWarnings("deprecation")
	private void prepareCounter(int ballTotalNumber) {
        int ballNumber = 1;
        while(ballNumber <= ballTotalNumber) {
            this.counterMap.put(new Integer(ballNumber), new Integer(0));
            ballNumber++;
        }
    }

    public Integer getCounter(Integer ballLabel) {
        return this.counterMap.get(ballLabel);
    }

    public int getCounterNumber() {
        return this.counterMap.size();
    }

    public HashMap<Integer, Integer> getAllCounters() {
        return this.counterMap;
    }

    @SuppressWarnings("deprecation")
	public void addElectedCount(List<Ball> basket) {
        for (int index = 0 ; index < basket.size() ; index++ ) {
            int ballLabel = basket.get(index).getLabel();
			int currentCount = this.counterMap.get(new Integer(ballLabel));
            int plusedCount = currentCount + 1;
            this.counterMap.replace(new Integer(ballLabel), new Integer(plusedCount));
        }
    }

	public void addElectedNumbersSet(List<Ball> basket) {
		ArrayList<String> list = new ArrayList<String>();
		for(Ball ball : basket) {
			list.add(String.valueOf(ball.getLabel()));
		}
		
		electedNumbersSetList.add(new HashSet<String>(list));
	}

	public boolean hasEnoughSet(List<Ball> basket, int enoughCount) {
		ArrayList<String> list = new ArrayList<String>();
		for(Ball ball : basket) {
			list.add(String.valueOf(ball.getLabel()));
		}
		
		HashSet<String> basketSet = new HashSet<String>(list);
		
		int count = 0;
		for (Set<String> electedNumbersSet : electedNumbersSetList) {
			if (electedNumbersSet.equals(basketSet)) {
				count += 1;
			}
			if (count >= enoughCount) {
				return true;
			}
		}

		return false;
	}

    public void sortByDescending() {
        this.ballLabels.addAll(this.counterMap.keySet());

        Collections.sort(this.ballLabels, new Comparator<Integer>() {
            public int compare(Integer object1, Integer object2) {
                Integer value1 = counterMap.get(object1);
                Integer value2 = counterMap.get(object2);

                return (value1.compareTo(value2));
            }
        });

        Collections.reverse(this.ballLabels);
    }

    public List<Integer> getFinalLabels(int ballElectNumber) {
    	// 가장 많이 추첨된 번호 순으로 정렬
    	this.sortByDescending();
    	
    	// 가장 많이 추첨된 번호 중에서 ballElectNumber 수만큼 선택
        List<Integer> finalLabels = new ArrayList<Integer>();
        for (int index = 0 ; index < ballElectNumber ; index++) {
            finalLabels.add(ballLabels.get(index));
        }

        // 
        Collections.sort(finalLabels, new Comparator<Integer>() {
            public int compare(Integer integer1, Integer integer2) {
                return (integer1.compareTo(integer2));
            }
        });

        return finalLabels;
    }
}
