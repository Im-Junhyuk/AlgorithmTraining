import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static int L;
	static int C;
	static char[] letters;
	
	static Set<Character> vowels;
	static char[] crypto;
	static StringBuilder sb;
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		letters = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			letters[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(letters);
		crypto = new char[L];
		sb = new StringBuilder();
		vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		
		
		combination(0, 0);
		System.out.println(sb);
	}

	
	static void combination(int start, int len) {
		if(len == L) {
			int consonant = 0;
			int vowel = 0;
			for(int i = 0; i < L; i++) {
				if(vowels.contains(crypto[i]))
					vowel++;
				else
					consonant++;
			}
			if(vowel >= 1 && consonant >= 2) {
				for(int i = 0; i < L; i++) {
					sb.append(crypto[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i = start; i < C; i++) {
			crypto[len] = letters[i];
			combination(i+1, len+1);
		}
	}
}