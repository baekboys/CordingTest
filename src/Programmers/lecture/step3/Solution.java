package lecture.step3;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/10302/lessons/62949
문제 설명
국가의 역할 중 하나는 여러 지방의 예산요청을 심사하여 국가의 예산을 분배하는 것입니다. 국가예산의 총액은 미리 정해져 있어서 모든 예산요청을 배정해 주기는 어려울 수도 있습니다. 그래서 정해진 총액 이하에서 가능한 한 최대의 총 예산을 다음과 같은 방법으로 배정합니다.

1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정합니다.
2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정합니다.
   상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정합니다.
예를 들어, 전체 국가예산이 485이고 4개 지방의 예산요청이 각각 120, 110, 140, 150일 때, 상한액을 127로 잡으면 위의 요청들에 대해서 각각 120, 110, 127, 127을 배정하고 그 합이 484로 가능한 최대가 됩니다.
각 지방에서 요청하는 예산이 담긴 배열 budgets과 총 예산 M이 매개변수로 주어질 때, 위의 조건을 모두 만족하는 상한액을 return 하도록 solution 함수를 작성해주세요.

제한 사항
지방의 수는 3 이상 100,000 이하인 자연수입니다.
각 지방에서 요청하는 예산은 1 이상 100,000 이하인 자연수입니다.
총 예산은 지방의 수 이상 1,000,000,000 이하인 자연수입니다.
입출력 예
budgets	M	return
[120, 110, 140, 150]	485	127
 */
class Solution {

    public int solution(int[] budgets, int M) {
        int answer = 0;

        ArrayList<Integer> integerArrayList = new ArrayList<>(budgets.length);

        int sum = 0;
        for (int i: budgets
             ) {
            integerArrayList.add(i);
            sum += i;
        }
        Collections.sort(integerArrayList);

        int min = integerArrayList.get(0);
        int max = integerArrayList.get(integerArrayList.size()-1);

        if( M >= sum) {
            return max;
        }

        int index = (min + max) / 2;
        boolean stop_flag = true;
        while (stop_flag) {
            int add = 0;
            int size = integerArrayList.size();

            for (int i = 0; i < size ; i++) {
                int temp_budget = integerArrayList.get(i);

                if(temp_budget >= index) {
                    add += (size -i) * index;
                    break;
                }

                add += temp_budget;
            }

            if(add == M || max - min <= 1) {
                answer = index;
                stop_flag = false;
            }
            else if (add > M) {
                max = index;
                index = (min + index) / 2;
            }
            else if (add < M) {
                min = index;
                index = (max + index) / 2;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // write your code here
        Solution s = new Solution();

        int[] budgets = {120, 110, 140, 150};
        int M = 485;

        int result;
        result = s.solution(budgets, M);

        System.out.println("result : " + result);
    }
}