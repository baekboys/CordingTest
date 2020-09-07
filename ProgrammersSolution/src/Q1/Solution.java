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
        	
        	//���� ����
        	Rank r = new Rank(temp[0], Integer.parseInt(temp[1]));
        	
        	// ó�� ����
        	if(ll.isEmpty()) {
        		ll.add(r);
        		answer++;
        	} 
        	else {
        		
        		// �ְ�ŷ
        		Rank first = ll.getFirst();
        		
        		// ��������ŷ
        		Rank last = ll.getLast();
        		
        		// ----------------------------------------------------------
        		// ���������� ������ ��ŷ�� �������� �۰ų� ������ ó��
        		// ----------------------------------------------------------
        		if(r.score <= last.score ) {
        			// ���� �������� �ȿ� ��ŷ�� �� ������ ������ �߰�
        			if(ll.size() <  K) {
    					ll.add(r);
    					answer++; // ������ ������Ʈ
    				}
        		}
        		// ----------------------------------------------------------
        		// ���������� �ְ�ŷ�� �������� ū ��� ó��
        		// ----------------------------------------------------------
        		else if(r.score > first.score) {
        			// ���������� �̸��� �ְ�ŷ�� ������ �̸��̸� ������ ������Ʈ
        			if(r.name.equals(first.name)) {
    					first.score = r.score;
    				}
        			// ���������� �ְ�ŷ���� �߰�
        			else {
        				ll.addFirst(r);
            			answer++; // ������ ������Ʈ
            			// ���������� �ѱ��� ������ ��ŷ�� ����
            			if(ll.size() > K) {
    						ll.removeLast();
    					}
        			}
        		}
        		// ----------------------------------------------------------
        		// ���������� �ְ������� ������ ���� ���̿� �ִ� ��� ó��
        		// ----------------------------------------------------------
        		else {
        			// ������ŷ�� �������� �Ųٷ� ��ȸ�Ͽ� ��
        			for(int i = ll.size()-1 ; i >= 0 ; i--) {
            			
        				// ���� ��ũ
        				Rank curRank = ll.get(i);
            			// ���� ��ũ
        				Rank preRank = i -1 < 0 ? curRank : ll.get(i-1);
            			
        				// ���������� ���緩ũ�� ������ �� ��ũ�� ���� ������ ���
            			if(r.score > curRank.score && r.score < preRank.score) {
            				// �̸��� ������ ������ ������Ʈ
            				if(r.name.equals(curRank.name)) {
            					curRank.score = r.score;
            				}
            				// ���緩ũ�� �̸��� ���� �ʰ� ������ũ�� �̸��� ���� �������
            				else if (!r.name.equals(preRank.name)) {
            					// ���������� �߰�
            					ll.add(i, r);
            					answer++; // ������ ������Ʈ
            					
            					// ���������� �ѱ��� ������ ��ŷ�� ����
            					if(ll.size() > K) {
            						ll.removeLast();
            					}
            				}
            				// �ݺ��� ����
            				break;
            			}
            		}
        		}
        		
        	}
		}
        
        return answer;
    }
}
