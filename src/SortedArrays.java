import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SortedArrays {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		long count = 0;
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			int diff = 0;
			if (i > 0 && array[i - 1] >= array[i]) {
				diff = array[i - 1] - array[i] + 1;
				count = count + diff;
				array[i] = array[i] + diff;
			}
		}
		System.out.println(count);
	}
}
