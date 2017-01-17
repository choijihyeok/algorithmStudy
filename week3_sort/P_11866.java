package Problems;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 2017-01-16
 * 문제 번호 : 11866
 * 문제 이름 : 조세퍼스
 * 문제 사이트 주소 : https://www.acmicpc.net/problem/11866
 */
class P_11866 { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int n = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int finalNum = 0; //n번 출력 했는지 검사
        int flag = 0; //3까지 진행
        while (true) {
            flag = 0;
            for (int i = cnt; i <= numbers.length; i = (i + 1) % n) {
                if (numbers[i] == 0) {
                    //한번도 출력 안했다면
                    flag++;
                    if (flag == order) {
                        //order만큼 갯수 세기
                        numbers[i] = 1; //제거 표시
                        finalNum++;
                        if (finalNum != numbers.length) {
                            sb.append((i + 1) + ", ");
                        } else {//마지막 출력이면
                            sb.append((i + 1));
                        }
                        cnt = (i + 1) % n;//시작점 설정
                        break;
                    }
                }
            }
            if (finalNum == n) {
                //모두 다 출력했다면  while문 break
                break;
            }
        }


        sb.append(">");

        bw.write(sb.toString());
        bw.close();


    }


}
