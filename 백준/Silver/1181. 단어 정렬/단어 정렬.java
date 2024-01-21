import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] strArr = new String[N];
		
		for(int i = 0; i < N; i++) {
			strArr[i] = sc.next();
		}
		Arrays.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2){
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else {
					return s1.length() - s2.length();
				}
			}
		});
		System.out.println(strArr[0]);
		for(int i = 1; i < N; i++)
			if (!strArr[i].equals(strArr[i-1]))
				System.out.println(strArr[i]);
	}

}