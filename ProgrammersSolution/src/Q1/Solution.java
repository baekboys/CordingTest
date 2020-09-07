package Q1;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		
		
		int k = 3;
		String[] user_score = {"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110"};
		
		
		/*
		int k = 2;
		String[] user_score = {"cheries2 200", "alex111 100", "coco 150", "puyo 120"};
		 */
		
		int result = s.solution(k, user_score);
		
		System.out.println("result : " + result);
	}
	
	public int solution(int K, String[] user_scores) {
        int answer = 0;
        
        class Rank{
			String name;
			int score;
			
			public Rank(String name, int score) {
				super();
				this.name = name;
				this.score = score;
			}
		}
        
        LinkedList<Rank> ll = new LinkedList<>();

        for (String string : user_scores) {

        	String[] temp = string.split(" ");
        	
        	Rank r = new Rank(temp[0], Integer.parseInt(temp[1]));
        	
        	if(ll.isEmpty()) {
        		ll.add(r);
        	} else {
        		
        		Object[] array1 = ll.toArray();
        		
        		if(ll.size() >= K) {
        			
        		} else {
        			ll.add(r);
        		}
        		
        		Collections.sort(ll, new Comparator<Rank>() {
        			@Override
        			public int compare(Rank r1, Rank r2) {
        				if (r1.score < r2.score) {
        					return -1;
        				}
        				if (r1.score > r2.score) {
        					return 1;
        				}
        				return 0;
        			}
        		});
        		
        		Object[] array2 = ll.toArray();
        		for(int i = 0 ; i < array1.length ; i++) {
        			Rank r1 = (Rank) array1[i];
        			Rank r2 = (Rank) array2[i];
        			
        			if(!r1.name.equals(r2.name)) {
        				answer++;
        				break;
        			}
        		}
        	}
        	
        	/*
        	if(pq.isEmpty()) {
        		pq.offer(r);
        	} else {
        		Object[] array1 = pq.toArray();
        		
        		if(pq.size() >= K) {
        			
        			Rank last = (Rank)array1[array1.length-1];
        			
        			if(r.score > last.score) {            			
        				pq.poll();
            			pq.offer(r);
            		}
        		} else {
        			pq.offer(r);
        		}
        		
        		
        		Object[] array2 = pq.toArray();
        		
        		for(int i = 0 ; i < array1.length ; i++) {
        			Rank r1 = (Rank) array1[i];
        			Rank r2 = (Rank) array2[i];
        			
        			if(!r1.name.equals(r2.name)) {
        				answer++;
        				break;
        			}
        		}
        		
        	}
        	*/
		}
        
        return answer;
    }
}
