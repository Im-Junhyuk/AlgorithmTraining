import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] temp;
	
	static BufferedReader br;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		temp = new int[M];
		
		combination(1, 0);
		
		bw.flush();
	}

	public static void combination(int last, int depth) throws IOException {
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				bw.write(temp[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i = last; i <= N; i++) {
			temp[depth] = i;
			
			combination(i+1, depth+1);
		}
	}
}
