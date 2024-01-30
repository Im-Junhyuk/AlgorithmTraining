import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


;

public class Main {
	static int[] switchArr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int switchNum = Integer.parseInt(br.readLine());
		switchArr = new int[switchNum];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < switchNum; i++) {
			switchArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int personNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < personNum; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int sNum = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {
				turnOnAndOffMan(sNum);
			}
			if(gender == 2) {
				turnOnAndOffWoman(sNum);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < switchArr.length; i++) {
			if(i % 20 == 0&& i != 0)
				bw.write("\n");
			bw.write(switchArr[i] + " ");
		}
		bw.flush();
	}
	public static void turnOnAndOffMan(int sNum) {
		for(int i = 0; i < switchArr.length; i++) {
			if((i+1) % sNum == 0) {
				if(switchArr[i] == 0)
					switchArr[i] = 1;
				else {
					switchArr[i] = 0;
				}
			}
		}
	}
	public static void turnOnAndOffWoman(int sNum) {
		sNum--;
		if(switchArr[sNum] == 0)
			switchArr[sNum] = 1;
		else 
			switchArr[sNum] = 0;
		
		for(int i = 1; i < switchArr.length; i++) {
			int left = sNum - i;
			int right = sNum + i;
			if(left < 0 || right >= switchArr.length)
				break;
			
			if(switchArr[left] != switchArr[right])
				break;
			
			if(switchArr[left] == 0) {
				switchArr[left] = 1;
				switchArr[right] = 1;
			} else {
				switchArr[left] = 0;
				switchArr[right] = 0;
			}
		}
	}

}
