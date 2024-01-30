import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] state = new int[n];
		for (int i=0; i<n; i++) {
			state[i] = sc.nextInt();
		}
		
		int sn = sc.nextInt();
		for (int i=0; i<sn; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if (a == 1) {
				for (int ms = b-1; ms < n; ms += b) { //스위치 번호의 배수, 단 스위치의 인덱스는 스위치 번호의 -1
					state[ms] = 1 - state[ms];
				}
			}
			else if (a == 2) {
				int ws = b-1;
				state[ws] = 1 - state[ws];
				int left = ws-1;
				int right = ws+1;
				while (true) {
					if (left >= 0 && right < n && state[left] == state[right]) {
						state[left] = 1 - state[left];
						state[right] = 1 - state[right];
						left--;
						right++;
					}
					else {
						break;
					}
				}
			}
			
		}
		int br = (n-1)/20;
		
		for (int i=0; i<=br; i++) {
			for (int j=i*20; j<(i+1)*20; j++) {
				if(j>=n) {
					break;
				}
				System.out.printf("%d ", state[j]);
			}
			System.out.println();
		}
	}

}
