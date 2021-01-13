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



public class Solution3 {
    public static void main(String[] args) throws IOException {

        //String pool = "001122334455667788998800112233445566770011223344556677001122334455667700112233445566770011223344556677";
    	String pool = "001122334455667788998800112233445566770011223344556677001122334455667700112233445566770011223344556677";

        int result = Solution3.numOfIds(pool);

        System.out.println("RESULT : " + result);
    }
    
    public static int numOfIds(String pool) {
        // Write your code here
    	
    	int numOfIds = 0;

    	int num_8_cnt = 0;
    	int num_other_cnt = 0;
    	int pool_length = pool.length();
    	int max_make_id = pool.length() / 11;
    	
    	//-------------------------------
    	int cnt_num[] = new int[10];
		for (int i = 0; i < 10; i++) {
			String str_i = String.valueOf(i);
			int cnt_i = 0;

			for (int j = 0; j < pool_length; j++) {
				String str_j = String.valueOf(pool.charAt(j));

				if (str_i.equals(str_j)) {
					cnt_i++;
				}
			}

			cnt_num[i] = cnt_i;
		}

		for (int x = 0; x < cnt_num.length; x++) {
			System.out.println(x + ":" + cnt_num[x]);
		}
		//-------------------------------
    	
    	
    	for(int i = 0 ; i < pool_length ; i++) {
    		char num_8 = '8';
    		char pool_num = pool.charAt(i);
    		
    		if(num_8 == pool_num) {
    			num_8_cnt++;
    		} else {
    			num_other_cnt++;
    		}
    	}
    	
    	System.out.println("======================================");
    	System.out.println("num_8_cnt:" + num_8_cnt);
    	System.out.println("num_other_cnt:" + num_other_cnt);
    	System.out.println("pool_length:" + pool_length);
    	System.out.println("max_make_id:" + max_make_id);
    	System.out.println("======================================");
    	
    	if(num_8_cnt == 0) {
    		return 0;
    	}
    	
    	if(num_8_cnt >= max_make_id) {
    		numOfIds = max_make_id;
    	} else {
    		numOfIds = num_8_cnt;
    	}
    	
        return numOfIds;
    }
}