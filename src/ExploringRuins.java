import java.util.Scanner;

public class ExploringRuins {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] input = scanner.next().toCharArray();
		scanner.close();
		
		if(input.length == 1 && input[0] == '?') {
			input[0] = 'a';
		} else {
			for (int i = 0; i < input.length; i++) {
				if (input[i] == '?') {
					if (i == 0 && i+1 < input.length) {
						// first character, compare with next element alone
						if(input[i+1] == 'a') {
							input[i] = 'b';
						} else {
							input[i] = 'a';
						}
					} else if (i == input.length - 1) {
						// last character, compare with previous element alone
						if(input[i-1] == 'a') {
							input[i] = 'b';
						} else {
							input[i] = 'a';
						}
					} else {
						// compare with previous and next element
						if(input[i+1] == 'a' || input[i-1] == 'a') {
							input[i] = 'b';
						} else {
							input[i] = 'a';
						}
					}
				}
			}
		}
		
		System.out.println(String.valueOf(input));
	}
}
