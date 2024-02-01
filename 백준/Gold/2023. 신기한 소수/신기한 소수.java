import java.util.Scanner;

public class Main {

	static int N, newPrime;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sb = new StringBuilder();
		
		amazingPrime(0, 2);
		amazingPrime(0, 3);
		amazingPrime(0, 5);
		amazingPrime(0, 7);
		
		System.out.println(sb);
		
		
	}
	
	public static void amazingPrime(int cnt, int prime) {
		if (cnt == N-1) {
			sb.append(prime).append("\n");
		}
		
		else {
			for (int i=1; i<10; i+=2) {
				newPrime = prime*10 + i;
				if (isPrime(newPrime)) {
					amazingPrime(cnt+1, newPrime);
				}
			}
		}
	}	
	
	public static boolean isPrime(int prime) {
		
		for (int i=2; i<(Math.sqrt(prime)+1); i++) {
			if (prime%i == 0) {
				return false;
			}
		}
		
		return true;
	}

}
