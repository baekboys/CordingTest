import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Solution2 {
    public static void main(String[] args) throws IOException {

        String pool = "0011223344556677889988";

        int result = Solution2.numOfIds(pool);

        System.out.println("RESULT : " + result);
    }
    
    public static int numOfIds(String pool) {
        // Write your code here
    	
    	int numOfIds = 0;
    	
    	int position_8 = 0;
    	int size_of_pool = pool.length();
    	
    	HashSet<String> TID_set = new HashSet<String>(); 
    	
    	
    	// pool�� 0���� �����Ͽ� pool�� ������������ ���� �ݺ�
    	for(position_8 = 0 ; position_8 <= size_of_pool ;  ) {
    		position_8 = pool.indexOf("8", position_8);
    		
    		System.out.println("position_8 : " + position_8);
    		
    		// ������ ����
    		if(position_8 == -1) {
    			break;
    		}
    		
    		// ������ 8�� ã�Ƽ� 10�� ���Ͽ� 11�ڸ��� ������ ���ڿ����� ��ġ�� ũ�� ����
    		if(position_8 + 10 > size_of_pool) {
    			break;
    		}
    		
    		// TID ����
    		String TID = pool.substring(position_8, position_8+10);
    		System.out.println("TID : " + TID);
    		
    		// SET�� �߰�(�ߺ���� ����)
    		TID_set.add(TID);
    		
    		// ���� 8���ڿ��� ��ġ�� 10�� ���Ͽ� ��ġ ����
    		position_8 += 10;
    	}

    	numOfIds = TID_set.size();
    	
        return numOfIds;
    }
}