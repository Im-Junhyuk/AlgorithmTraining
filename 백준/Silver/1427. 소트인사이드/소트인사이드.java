import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] array = s.split("");
		Arrays.sort(array, Collections.reverseOrder());
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i]);
	}

}
