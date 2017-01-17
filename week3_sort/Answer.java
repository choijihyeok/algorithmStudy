import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	private static final Scanner sc = new Scanner(System.in);

	private void solve() {
		int n = sc.nextInt();
		int m = sc.nextInt();

		LinkedList<Integer> stack = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			stack.add(i + 1);
		}

		StringBuilder strBuilder = new StringBuilder("<");
		int k = 0;

		while (!stack.isEmpty()) {
			k += m - 1;
			while (k >= stack.size()) {
				k -= stack.size();
			}

			strBuilder.append(stack.get(k)).append(", ");
			stack.remove(k);
		}

		strBuilder.setLength(strBuilder.length() - 2);
		strBuilder.append(">");
		System.out.println(strBuilder.toString());
	}

	public static void main(String[] args) {
		new Main().solve();
	}
}
