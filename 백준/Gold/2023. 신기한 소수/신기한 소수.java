import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// init
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(2);
		arr.add(3);
		arr.add(5);
		arr.add(7);
		
		// repeat
		
		for(int i =1; i < N; i++) {
			
		// make candidate
			arr.replaceAll(v -> v * 10);
			ArrayList<Integer> newArr = new ArrayList<>();
		// isPrime
		// get surviver
			
			for(int v : arr) {
				if(isPrime(v+1))
					newArr.add(v + 1);
				if(isPrime(v+3))
					newArr.add(v + 3);
				if(isPrime(v+5))
					newArr.add(v + 5);
				if(isPrime(v+7))
					newArr.add(v + 7);
				if(isPrime(v+9))
					newArr.add(v + 9);
			}
		

			arr = newArr;
		// go to next
		
		}
		// after repeat, print
		StringBuilder sb = new StringBuilder();
		arr.forEach(e -> sb.append(e +"\n"));
		System.out.println(sb);
		
		
	}
	static boolean isPrime(int num) {
		for(int i = 3; i <= Math.sqrt(num); i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}

}
