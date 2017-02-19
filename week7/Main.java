
import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 2167
 * 문제 이름 : 2차원 배열의 합
 * 문제 주소 : https://www.acmicpc.net/problem/2167
 */

public class Main {

    void Solve() throws IOException {
        FileInputStream fis = new FileInputStream("input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] data = new int[(n * m) + 1];// 1차원 배열 생성
        int resultSum = 0; //결과 값
        int index = 1;
        while (n-- > 0) {
            //data 입력
            st = new StringTokenizer(br.readLine().trim());
            while (st.hasMoreTokens()) {
                data[index++] = Integer.parseInt(st.nextToken());
            }
        }

        int coordinateCnt = Integer.parseInt(br.readLine().trim());//좌표 갯수

        while (coordinateCnt-- > 0) {
            resultSum = 0;
            st = new StringTokenizer(br.readLine().trim());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = 0;
            if (i != 1) {
                for (int k = 1; k < i; k++) {
                    start += m;
                }
                start += j;

            } else {
                //if(i == 1)
                start = i * j;
            }


            if (x != 1) {
                for (int k = 1; k < x; k++) {
                    end += m;
                }
                end += y;

            } else {
                end = x * y;
            }


            if (i == x && j == y) {
                //좌표 범위 (i,j)~(x,y)
                //좌표범위가 같을 때
                resultSum = data[start];
            } else if (i != x && j == y) {
                //세로
                for (int k = start; k <= end; k += m) {
                    resultSum += data[k];
                }
            } else {
                //좌표범위가 다를 때
                int k = start; //data의 index 번호
                int startPoint = start;//시작점
                while (k <= end) {

                    for (int a = 0; a < (y - j) + 1; a++) {
                        resultSum += data[k++];
                    }
                    k = startPoint + m;//시작점 설정
                    startPoint = k;
                }
            }

            // System.out.println(resultSum);
            bw.write(resultSum + "\n");
        }
        bw.close();

    }

    public static void main(String[] args) throws Exception {
        new Main().Solve();


    }
}


