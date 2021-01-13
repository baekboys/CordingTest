package com.baek.cordingTest;

class Result {

    /*
     * Complete the 'decode' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING encoded as parameter.
     */

    public static String decode(String encoded) {
        // Write your code here

        // 최종 decode 문자열를 리턴할 스트링 버퍼 생성
        StringBuilder result = new StringBuilder();

        // encoded문자열을 역으로 뒤집기(로직 편의를 위해서...)
        String reverse = new StringBuffer(encoded).reverse().toString();

        // 65 ~ 90 : A ~ Z
        // 92 ~ 122 : a ~ z
        // 32 : 공백
        // 문자열을 인덱싱 할 변수
        int index = 0;

        // reverse된 문자열의 길이만큼 반복하여 처리
        while(index < reverse.length()) {
            // (1) index 위치로 부터 1개의 문자 가져옴
            char temp1 = reverse.charAt(index);

            // 아스키코드
            int ascii;

            // (2) 문자를 보고 분기처리
            // (2-1) 3이면 무조건 32가 나올수 밖에 없으므로 공백처리
            if( temp1 == '3') {
                // 공백밖에 없으므로 아스키코드는 32로 강제처리
                ascii = 32;
                // 인덱스 위치 변경
                index += 2;
            }
            // (2-2) 100을 넘어가는 경우 3자리까지 문자열을 자른다.
            else if ( temp1 == '1') {
                // 3자리 숫자로 변환
                ascii = Integer.parseInt(reverse.substring(index, index+3));
                // 인덱스 위치 변경
                index += 3;
            }
            // (2-3) 100 미만이면 2자리까지 문자열을 자른다.
            else {
                // 2자리 숫자로 변환
                ascii = Integer.parseInt(reverse.substring(index, index+2));
                // 인덱스 위치 변경
                index += 2;
            }

            // 아스키코드에서 char변환된 문자를 스트링버퍼에 append
            result.append((char) ascii);
        }

        // 최종 결과를 String으로 변환하여 리턴
        return result.toString();
    }

}

/*
StringBuffer result = new StringBuffer();

        // 역으로 뒤집기
        String reverse = new StringBuffer(encoded).reverse().toString();

        // 65 ~ 90 : A ~ Z
        // 92 ~ 122 : a ~ z
        // 32 : 공백
        int index = 0;
        while(index < reverse.length()) {
            char temp1 = reverse.charAt(index);
            int ascii = 0;

            // 공백처리
            if( temp1 == '3') {
                // 공백밖에 없음
                ascii = 32;
                index += 2;
            }
            // 100을 넘어가는 경우
            else if ( temp1 == '1') {
                // 3자리 숫자로 변환
                ascii = Integer.parseInt(reverse.substring(index, index+3));
                index += 3;
            }
            // 100 미만
            else {
                // 2자리 숫자로 변환
                ascii = Integer.parseInt(reverse.substring(index, index+2));
                index += 2;
            }

            result.append((char) ascii);
        }

        return result.toString();
 */

class Solution {



    public static void main(String[] args) {

        //String input = "23511011501782351112179911801562340161171141148"; // Truth Always Wins
        //String input = "2312179862310199501872379231018117927"; // Have a Nice Day
        String input = "1219950180111108236115111016623101401611235115012312161151110101111127"; // Honesty is the Best Policy

        String output = Result.decode(input);

        System.out.println(output);


        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String encoded = bufferedReader.readLine();

        String result = Result.decode(encoded);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
