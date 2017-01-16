package Problems;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 2017-01-16
 * 문제 번호 : 1026번
 * 문제 이름 : 보물
 * 문제 사이트 주소 : https://www.acmicpc.net/problem/1026
 */
class P_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N];
        int[] B = new int[N];
        int n = 2;
        boolean first = false;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int index = 0;

            while (st.hasMoreTokens()) {
                if (n == 1) {
                    A[index++] = Integer.parseInt(st.nextToken());
                } else {
                    B[index++] = Integer.parseInt(st.nextToken());
                }
            }
        }
        int minSum = 0; //촤솟값
        int sum = 0; //현재 합


        for (int i = A.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (A[j] > A[j + 1]) {
                    int tmp = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = tmp;
                }
            }
        }

        for (int i = B.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (B[j] < B[j + 1]) {
                    int tmp = B[j + 1];
                    B[j + 1] = B[j];
                    B[j] = tmp;
                }
            }
        }


        for(int i=0; i<A.length;i++)
        {
            sum+=A[i] * B[i];
        }

        System.out.println(sum);

    }


}