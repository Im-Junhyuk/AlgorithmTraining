import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		String dna = br.readLine();
		int[] countACGT = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++) {
			countACGT[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] accCountACGT = new int[s+1][4];
		for(int i=0; i<4; i++) {
			accCountACGT[0][i] = 0;
		}
		

		for (int i=0; i<s; i++) {
			accCountACGT[i+1] = accCountACGT[i].clone();
			if (dna.charAt(i) == 'A') {
				accCountACGT[i+1][0]++;
			}
			else if (dna.charAt(i) == 'C') {
				accCountACGT[i+1][1]++;
			}
			else if (dna.charAt(i) == 'G') {
				accCountACGT[i+1][2]++;
			}
			else if (dna.charAt(i) == 'T') {
				accCountACGT[i+1][3]++;
			}
		}
		
		int ans = 0;
		boolean flag = false;

		for (int i=p; i<s+1; i++) { //i번째와 i-p번째를 비교, 0번째 인덱스는 0으로 새로 추가하여 초기화
			for (int j=0; j<4; j++) { //A, C, G, T 검사
				if (accCountACGT[i][j] - accCountACGT[i-p][j] < countACGT[j]) { //주어진 개수보다 모자란 경우
					flag = true; //i문을 다음단계로 넘기기 위해 for문 탈출 flag
					break;
				}
			}
			if (flag == true) {
				flag = false;
				continue;
			}
			ans += 1; //주어진 개수를 모두 만족한 경우
		}
		
		System.out.println(ans);
		

	}
	

}
