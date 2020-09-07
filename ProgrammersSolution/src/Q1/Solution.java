package Q1;

import java.util.LinkedList;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		
		
		int k = 3;
		String[] user_score = {"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110", "coco 400"};
		
		//int k = 2;
		//String[] user_score = {"cheries2 200", "alex111 100", "coco 150", "puyo 120"};
		
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
        	
        	//현재 점수
        	Rank r = new Rank(temp[0], Integer.parseInt(temp[1]));
        	
        	// 처음 수행
        	if(ll.isEmpty()) {
        		ll.add(r);
        		answer++;
        	} 
        	else {
        		
        		// 최고랭킹
        		Rank first = ll.getFirst();
        		
        		// 마지막랭킹
        		Rank last = ll.getLast();
        		
        		// ----------------------------------------------------------
        		// 현재점수가 마지막 랭킹의 점수보다 작거나 같으면 처리
        		// ----------------------------------------------------------
        		if(r.score <= last.score ) {
        			// 아직 한페이지 안에 랭킹이 다 차있지 않으면 추가
        			if(ll.size() <  K) {
    					ll.add(r);
    					answer++; // 페이지 업데이트
    				}
        		}
        		// ----------------------------------------------------------
        		// 현재점수가 최고랭킹의 점수보다 큰 경우 처리
        		// ----------------------------------------------------------
        		else if(r.score > first.score) {
        			// 현재점수의 이름이 최고랭킹과 동일한 이름이면 점수만 업데이트
        			if(r.name.equals(first.name)) {
    					first.score = r.score;
    				}
        			// 현재점수를 최고랭킹으로 추가
        			else {
        				ll.addFirst(r);
            			answer++; // 페이지 업데이트
            			// 한페이지를 넘긴경우 마지막 랭킹은 삭제
            			if(ll.size() > K) {
    						ll.removeLast();
    					}
        			}
        		}
        		// ----------------------------------------------------------
        		// 현재점수가 최고점수와 마지막 점수 사이에 있는 경우 처리
        		// ----------------------------------------------------------
        		else {
        			// 낮은랭킹의 점수부터 거꾸로 순회하여 비교
        			for(int i = ll.size()-1 ; i >= 0 ; i--) {
            			
        				// 현재 랭크
        				Rank curRank = ll.get(i);
            			// 상위 랭크
        				Rank preRank = i -1 < 0 ? curRank : ll.get(i-1);
            			
        				// 현재점수가 현재랭크의 점수와 전 랭크의 점수 사이인 경우
            			if(r.score > curRank.score && r.score < preRank.score) {
            				// 이름이 같으면 점수만 업데이트
            				if(r.name.equals(curRank.name)) {
            					curRank.score = r.score;
            				}
            				// 현재랭크의 이름도 같지 않고 상위랭크의 이름도 같지 않은경우
            				else if (!r.name.equals(preRank.name)) {
            					// 현재점수를 추가
            					ll.add(i, r);
            					answer++; // 페이지 업데이트
            					
            					// 한페이지를 넘긴경우 마지막 랭킹은 삭제
            					if(ll.size() > K) {
            						ll.removeLast();
            					}
            				}
            				// 반복문 중지
            				break;
            			}
            		}
        		}
        		
        	}
		}
        
        return answer;
    }
}