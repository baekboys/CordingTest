package com.baek.cordingTest;

/**
 * 2번 문제 : 아래의 버그를 2줄만 고쳐서 완성하시오
 *
 *int solution(int[] A) {
 *         int n = A.length;
 *         int i = n - 1;
 *         int result = -1;
 *         int k = 0, maximal = 0;
 *         while (i > 0) {
 *             if (A[i] == 1) {
 *                 k = k + 1;
 *                 if (k >= maximal) {
 *                     maximal = k;
 *                     result = i;
 *                 }
 *             }
 *             else
 *                 k = 0;
 *             i = i - 1;
 *         }
 *         if (A[i] == 1 && k + 1 > maximal)
 *             result = 0;
 *         return result;
 *     }
 */
class Solution2 {

    int solution(int[] A) {
        int n = A.length;
        int i = n - 1;
        int result = -1;
        int k = 0, maximal = 0;
        while (i > 0) {
            if (A[i] == 1) {
                k = k + 1;
                if (k >= maximal) {
                    maximal = k;
                    result = i;
                }
            }
            else
                k = 0;
            i = i - 1;
        }
        if (A[i] == 1 && k + 1 == maximal)
            result = 0;
        return result;
    }
}