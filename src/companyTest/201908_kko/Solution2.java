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
    	
    	
    	// pool의 0부터 시작하여 pool의 마지막사이즈 까지 반복
    	for(position_8 = 0 ; position_8 <= size_of_pool ;  ) {
    		position_8 = pool.indexOf("8", position_8);
    		
    		System.out.println("position_8 : " + position_8);
    		
    		// 없으면 종료
    		if(position_8 == -1) {
    			break;
    		}
    		
    		// 마지막 8을 찾아서 10을 더하여 11자리가 마지막 문자열보다 위치가 크면 종료
    		if(position_8 + 10 > size_of_pool) {
    			break;
    		}
    		
    		// TID 추출
    		String TID = pool.substring(position_8, position_8+10);
    		System.out.println("TID : " + TID);
    		
    		// SET에 추가(중복허용 안함)
    		TID_set.add(TID);
    		
    		// 현재 8문자열의 위치에 10을 더하여 위치 변경
    		position_8 += 10;
    	}

    	numOfIds = TID_set.size();
    	
        return numOfIds;
    }
}