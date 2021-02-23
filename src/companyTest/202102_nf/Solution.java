package com.baek.cordingTest;

/**
 * 1번 문제
 */
class Solution {

    public int solution(String[] A) {
        // write your code in Java SE 8

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length ; i++) {
            Integer count = map.getOrDefault(A[i], 0);
            map.put(A[i], ++count);
        }
        int max = map.entrySet().stream().mapToInt((x) -> x.getValue()).max().getAsInt();

        return max;
    }
}