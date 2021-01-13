import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/*
아나그램 놀이
두 문자열이 서로의 순열인 경우 이들을 아나그램이라고 합니다. 예를 들어, "aaagmnrs"는 "anagrams"의 아나그램입니다. 문자열 배열이 주어졌을 때, 이전 문자열의 아나그램인 문자열들을 제거한 후, 남은 배열을 정렬된 순서로 반환하십시오.
예를 들어 s = ['code', 'doce', 'ecod', 'framer', 'frame'] 배열이 주어졌을 때, 문자열 'doce'와 'ecod'는 모두 'code'의 아나그램이므로 배열에서 제거됩니다. 'frame'과 'framer'는 'framer'의 추가 'r'로 인해 아나그램이 아니므로 배열에 그대로 남습니다. 따라서, 알파벳순으로 정렬된 최종 문자열 배열은 ['code', 'frame', 'framer']가 됩니다.
함수 설명
아래 에디터에 funWithAnagrams 함수를 완성하십시오. 이 함수는 문자열 배열을 오름차순 알파벳순으로 반환해야 합니다.
funWithAnagrams 함수는 다음 매개 변수들을 받습니다:
s[s[0],...s[n-1]]: 문자열 배열
제약 조건
1 ≤ n ≤ 1000
1 ≤ |s[i]| ≤ 1000
각 문자열 s[i]는 ascii[a-z] 범위에 속한 문자들로 이루어져 있습니다
 
 */

public class Solution_num2 {
    public static void main(String[] args) throws IOException {

    	List<String> String_list = new ArrayList<String>();

    	String_list.add("4");
    	String_list.add("code");
    	String_list.add("aaagmnrs");
    	String_list.add("anagrams");
    	String_list.add("doce");

        //int result = Solution.funWithAnagrams(pool);
    	
    	List<String> result_list = Solution_num2.funWithAnagrams(String_list);

        System.out.println("RESULT : " + result_list);
    }

    public static List<String> funWithAnagrams(List<String> s) {
        // Write your code here
    	List<String> result_list = new ArrayList<String>();
    	
    	HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>(); 
    	
    	for (String param_s : s) {
    		
    		if(param_s.matches("-?\\d+(\\.\\d+)?")) {
    			System.out.println("���ڶ� �н�!!!");
    			continue;
    		}
    		
    		char[] sol = param_s.toCharArray();
    		Arrays.sort(sol);
    		
    		String ord_s =  new String(sol);
    		
    		System.out.println(param_s + "," + ord_s);
    		
    		ArrayList<String> map_in_list = map.get(ord_s);
    		if (map.get(ord_s) == null) {
    			ArrayList<String> new_map_in_list = new ArrayList<String>();
    			new_map_in_list.add(param_s);
    			map.put(ord_s, new_map_in_list);
    		} else {
    			map_in_list.add(param_s);
    		}
		}
    	
    	
    	Iterator<String> keySetIterator = map.keySet().iterator();
    	System.out.println("=========================================");
		while (keySetIterator.hasNext()) {
		    String key = keySetIterator.next();
		    
		    ArrayList<String> word_list = map.get(key);
		    
		    //���ľ���
		    //Collections.sort(word_list);
		    System.out.println("key: " + key + " value: " + word_list);
		    result_list.add(word_list.get(0));
		}
    	
		Collections.sort(result_list);
		System.out.println("=========================================");
		System.out.println(result_list);
		
    	return result_list;
    }
}