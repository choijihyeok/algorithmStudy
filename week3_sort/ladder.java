import java.io.*;
import java.util.*;

/**
 * 2017-01-16
 * 문제 번호 : 3061번
 * 문제 이름 : 사다리
 * 문제 사이트 주소 : https://www.acmicpc.net/problem/3061
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        while (N-- > 0) {
            int inputNumCnt = Integer.parseInt(br.readLine().trim());
            int[] numbers = new int[inputNumCnt];
            st = new StringTokenizer(br.readLine().trim());
            int index = 0;
            int ladderCnt = 0;
            while (st.hasMoreTokens()) {
                numbers[index++] = Integer.parseInt(st.nextToken());
            }
            for (int i = numbers.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (numbers[j] > numbers[j + 1]) {
                        ladderCnt++;
                        int tmp = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = tmp;
                    }
                }
            }
            bw.write(ladderCnt + "\n");
        }
        bw.close();
    }


}
