package com.baek.cordingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


class Result2 {

    /*
     * Complete the 'countSignals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY frequencies
     *  2. 2D_INTEGER_ARRAY filterRanges
     */

    public static int countSignals(List<Integer> frequencies, List<List<Integer>> filterRanges) {
        // Write your code here

        // 최종 결과 값
        int result = 0;

        // 필터 범위 첫번째의 최대값 구하기
        int filter1 =  filterRanges.stream()
                .mapToInt(x -> x.get(0))
                .max().orElseThrow(NoSuchElementException::new);

        // 필터 범위 두번째 최소값 구하기
        int filter2 =  filterRanges.stream()
                .mapToInt(x -> x.get(1))
                .min().orElseThrow(NoSuchElementException::new);

        // 주파수 개수만큼 반복하여 필터 범위에 해당되면 결과값 증가
        for (Integer frequenciesList: frequencies
             ) {
            if(frequenciesList >= filter1 && frequenciesList <= filter2) {
                result++;
            }
        }

        // 최종결과값 리턴
        return result;
    }

}
/*
        // 최종 결과 값
        int result = 0;

        // 필터 범위 첫번째 최대값
        int filter1 = 0;
        // 필터 범위 두번째 최소값
        int filter2 = 0;

        // 필터 범위 값 추출
        for (List<Integer> integerList: filterRanges
             ) {
            int firstVal = integerList.get(0);
            int secondVal = integerList.get(1);

            if (filter1 == 0 || filter1 < firstVal) {
                filter1 = firstVal;
            }

            if (filter2 == 0 || filter2 > secondVal) {
                filter2 = secondVal;
            }
        }

        // 주파수 개수만큼 반복하여 범위에 해당되는지 확인
        for (Integer frequenciesList: frequencies
             ) {
            int frequency = frequenciesList.intValue();

            if(frequency >= filter1 && frequency <= filter2) {
                result++;
            }
        }

        // 결과 리턴
        return result;
 */
public class Solution2 {
    public static void main(String[] args) {

        // 주파수
        List<Integer> input1 = new ArrayList<>();
        input1.add(8);
        input1.add(15);
        input1.add(14);
        input1.add(16);
        input1.add(21);

        List<List<Integer>> input2 = new ArrayList<>();

        // 필터 1
        List<Integer> input2_1 = new ArrayList<>();
        input2_1.add(10);
        input2_1.add(17);
        input2.add(input2_1);

        // 필터 2
        List<Integer> input2_2 = new ArrayList<>();
        input2_2.add(13);
        input2_2.add(15);
        input2.add(input2_2);

        // 필터 3
        List<Integer> input2_3 = new ArrayList<>();
        input2_3.add(13);
        input2_3.add(17);
        input2.add(input2_3);

        int result = Result2.countSignals(input1, input2);
        System.out.println(result);

        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int frequenciesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> frequencies = IntStream.range(0, frequenciesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int filterRangesRows = Integer.parseInt(bufferedReader.readLine().trim());
        int filterRangesColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> filterRanges = new ArrayList<>();

        IntStream.range(0, filterRangesRows).forEach(i -> {
            try {
                filterRanges.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.countSignals(frequencies, filterRanges);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
