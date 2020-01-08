import java.util.HashSet;

public class Combination {
	
	public HashSet<String> set = new HashSet<String>();
 
    public static void main(String[] args) {
        
    	Combination c = new Combination();
    	
    	int result = c.Solution(1, 2);
    	System.out.println("°á°ú:" + result);
    }
    
    public int Solution(int n, int m) {
    	int answer = 0;
    	
    	String n_str = "(";
    	String m_str = ")";
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0 ; i < n ; i++) {
    		sb.append(n_str);
    	}
    	
    	for(int j = 0 ; j < m ; j++) {
    		sb.append(m_str);
    	}
    	
    	permutation(sb.toString());
    	
    	printHashSet();
    	
    	answer = set.size();
    	
    	return answer;
    }
    
    private void printHashSet() {
    	
    	Object[] o_array = set.toArray(); 
    	
    	for(int i = 0 ; i < o_array.length ; i++) {
    		System.out.printf("%3d:%s\n", i, o_array[i]);
    	}
    }
     
    private void permutation(String str) { 
        permutation("", str); 
    }

    private void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) set.add(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}