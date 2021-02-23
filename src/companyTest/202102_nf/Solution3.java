package com.baek.cordingTest;

/**
 * 3번 문제
 */
class Solution3 {

    private Set<String> timeSet = new HashSet<>();

    public static void main(String[] args) {
        Solution solution = new Solution();

        //int A = 1, B = 8, C = 3, D = 2;
        int A = 2, B = 3, C = 3, D = 2;
        //int A = 6, B = 2, C = 4, D = 7;
        int resultC = solution.solution(A, B, C, D);
        System.out.println(resultC);
    }

    public int solution(int A, int B, int C, int D) {
        // write your code in Java SE 8
        String str = Integer.valueOf(A).toString()
                + Integer.valueOf(B).toString()
                + Integer.valueOf(C).toString()
                + Integer.valueOf(D).toString()
                ;

        permutation("", str);

        int hhLimit = 24;
        int mmLimit = 59;

        int result = 0;
        for (String s : timeSet) {
            int hh = Integer.parseInt(s.substring(0, 2));
            int mm = Integer.parseInt(s.substring(2, 4));

            if (hh <= hhLimit && mm <= mmLimit) {
                result++;
                System.out.println(s);
            } else {
                System.out.println("limit over : " + s);
            }
        }
        return result;
    }

    private void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) timeSet.add(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}