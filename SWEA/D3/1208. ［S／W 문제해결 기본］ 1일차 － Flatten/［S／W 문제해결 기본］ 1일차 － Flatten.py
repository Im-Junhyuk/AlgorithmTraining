/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
	public static void main(String args[]) throws IOException {
		//System.setIn(new FileInputStream("input_flat.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc < 11; tc++) {
			
			
			int dump = Integer.parseInt(br.readLine());
			int ground[] = new int[100];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 100; i++) {
				ground[i] = Integer.parseInt(st.nextToken());
			}
			
			
			while(dump > 0) {
				int max = -1;
				int min = 101;
				
				int maxIdx = 0;
				int minIdx = 0;
				
				for(int i = 0; i < 100; i++) {
					if(ground[i] > max) {
						max = ground[i];
						maxIdx = i;
					}
					if(ground[i] < min) {
						min = ground[i];
						minIdx = i;
					}
				}
				ground[maxIdx]--;
				ground[minIdx]++;
				
				dump--;
			}
			
			int max = -1;
			int min = 101;

			for(int i = 0; i < 100; i++) {
				if(ground[i] > max) {
					max = ground[i];
				}
				if(ground[i] < min) {
					min = ground[i];
				}
			}
			int gap = max - min;
			System.out.println("#" + tc + " " + gap);
		}
	}
}
