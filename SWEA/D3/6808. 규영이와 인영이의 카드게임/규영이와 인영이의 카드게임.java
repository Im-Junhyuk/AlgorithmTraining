import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {
	
	static int[] set1;
	static int[] set2;
	static int[] temp;
	static boolean[] selected;
	static boolean[] selected2;
	
	static int win;
	static int loss;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			set1 = new int[9];
			set2 = new int[9];
			temp = new int[9];
			
			win = 0;
			loss = 0;
			
			selected = new boolean[19];
			for(int i = 0; i < 9; i++) {
				set1[i] = Integer.parseInt(st.nextToken());
				selected[set1[i]] = true;
			}
			int index = 0;
			for(int i = 1; i < 19; i++) 
				if(selected[i] == false) 
					set2[index++] = i;
			selected2 = new boolean[9];
//			permutation(0);
			Arrays.sort(set2);
			temp = set2;
			nextPermutation();
			
			System.out.println("#" + t + " " + win + " " + loss);
		}
	}
	static void nextPermutation() {
		while(true) {
			game();
			int i = set2.length-1;
			while(i >= 1 && set2[i-1] > set2[i]) 
				i--;
			if(i == 0)
				return;
			int j = set2.length-1;
			while(set2[i-1] >= set2[j])
				j--;
			
			int tem = set2[i-1];
			set2[i-1] = set2[j];
			set2[j] = tem;
			
			Arrays.sort(set2, i, set2.length);
			temp = set2;
		}
		
		
	}
	static void permutation(int len) {
		if(len == 9) {
			game();
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(selected2[i] == false) {
				selected2[i] = true;
				temp[len] = set2[i];
				permutation(len+1);
				selected2[i] = false;
			}
		}
	}
	
	static void game() {
		int score1 = 0;
		int score2 = 0;
		
		for(int i = 0; i < 9; i++) {
			if(set1[i] > temp[i])
				score1 += set1[i] + temp[i];
			else
				score2 += set1[i] + temp[i];
		}
		
		if(score1 > score2)
			win++;
		else 
			loss++;
	}
}