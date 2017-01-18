import java.io.*;
import java.util.*;

/**
 * 2017-01-17
 * 문제 번호 : 5544
 * 문제 이름 : 리그
 * 문제 사이트 주소 : https://www.acmicpc.net/problem/5544
 */
class Main {

    public static int[] BubbleSort(int[] arr) {
        int[] tmpArr = arr.clone();
        for (int i = tmpArr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (tmpArr[j] < tmpArr[j + 1]) {
                    int tmp = tmpArr[j];
                    tmpArr[j] = tmpArr[j + 1];
                    tmpArr[j + 1] = tmp;
                }
            }
        }
        return tmpArr;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int teamCnt = Integer.parseInt(br.readLine().trim()); // 팀 수
        int[] teamScore = new int[teamCnt]; //팀 점수
        int matchCnt = teamCnt * (teamCnt - 1) / 2; //경기 수
        int[] tmpArr; //팀 점수 정렬 배열
        int[] rankArr = new int[teamCnt];//순위
        while (matchCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            int teamA = Integer.parseInt(st.nextToken()) - 1;
            int teamB = Integer.parseInt(st.nextToken()) - 1;
            int teamA_Score = Integer.parseInt(st.nextToken());
            int teamB_Score = Integer.parseInt(st.nextToken());

            if (teamA_Score > teamB_Score) {//A가 이겼을 경우
                teamScore[teamA] += 3;
            } else if (teamA_Score < teamB_Score) {//B가 이겼을 경우
                teamScore[teamB] += 3;
            } else if (teamA_Score == teamB_Score) {//무승부 일 경우
                teamScore[teamA] += 1;
                teamScore[teamB] += 1;
            }
        }
        tmpArr = BubbleSort(teamScore);

        int rankNum = 1;
        int overlapRank = 0;//중복 점수 갯수
        int previousNum = 0;
        for (int i = 0; i < tmpArr.length; i++) {
            if (i != tmpArr.length - 1) {
                //마지막 배열이 아니라면
                if (tmpArr[i] != tmpArr[i + 1]) {//점수가 다르다면
                    if (overlapRank != 0 && previousNum == tmpArr[i]) {//중복 순위가 있고, 전 숫자와 현대 숫자와 일치한다면
                        rankArr[i] = rankNum;
                        overlapRank++;

                    } else {
                        rankArr[i] = (rankNum++) + overlapRank;
                        overlapRank = 0;//중복 점수 갯수 초기화
                    }

                } else {//점수가 동일하면
                    rankArr[i] = rankNum;
                    overlapRank++;
                    previousNum = tmpArr[i];
                }
            } else {
                //마지막 배열이면
                if (previousNum == tmpArr[i]) {//전 숫자와 지금 숫자가 일치하면
                    rankArr[i] = rankNum;
                } else {
                    if(overlapRank != 0) {//중복된 숫자가 있으면
                        rankArr[i] = rankArr[i - 1] + overlapRank;
                    }else{
                        rankArr[i] = rankArr[i - 1] + 1;
                    }
                }
            }
        }

        for (int i = 0; i < teamScore.length; i++) {
            for (int j = 0; j < tmpArr.length; j++) {
                if (teamScore[i] == tmpArr[j]) {
                    if (i != rankArr.length - 1) {
                        bw.write(rankArr[j] + " ");
                    } else {
                        bw.write(Integer.toString(rankArr[j]));
                    }
                    break;
                }
            }
        }
        bw.close();
    }


}