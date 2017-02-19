import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2차원 배열의 합
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine().trim());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int[][] matrix=new int[n+1][m+1];
		int sum=0;
		for(int r=1 ; r<=n ; r++){
			st=new StringTokenizer(br.readLine().trim());
			sum=0;
			for(int c=1 ; c<=m ; c++){
				int a=Integer.parseInt(st.nextToken());
				sum+=a;
				matrix[r][c]=sum;
			}
		}
		int k=Integer.parseInt(br.readLine().trim());
		StringBuilder sb=new StringBuilder();
		for(int i=1 ; i<=k ; i++){
			st=new StringTokenizer(br.readLine().trim());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int result=0;
			for(int r=a ; r<=c ; r++){
				result+=matrix[r][d]-matrix[r][b-1];
			}
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}
}