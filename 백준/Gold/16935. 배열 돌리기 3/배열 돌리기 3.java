import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int r = 0; r < R; r++) {
			String inst = st.nextToken();
			
			switch (inst) {
			case "1":
				updown();
				break;
			case "2":
				leftright();
				break;
			case "3":
				right();
				break;
			case "4":
				left();
				break;
			case "5":
				clockwise();
				break;
			case "6":
				antiClockwise();
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				sb.append(arr[i][j])
				.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	static void updown() {
		int N = arr.length;
		int M = arr[0].length;
		
		int[][] newArr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				newArr[N-1-i][j] = arr[i][j];
			}
		}
		arr = newArr;
	}
	
	static void leftright() {
		int N = arr.length;
		int M = arr[0].length;
		int[][] newArr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				newArr[i][M-1-j] = arr[i][j];
			}
		}
		arr = newArr;
	}

	static void right() {
		int N = arr.length;
		int M = arr[0].length;
		
		int[][] newArr = new int[M][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
					newArr[j][N-1-i] = arr[i][j];	
			}
		}
		arr = newArr;
	}
	
	static void left() {
		int N = arr.length;
		int M = arr[0].length;
		
		int[][] newArr = new int[M][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
					newArr[M-1-j][i] = arr[i][j];	
			}
		}
		arr = newArr;
		
	}
	
	static void clockwise() {
		int N = arr.length;
		int M = arr[0].length;
		int[][] newArr = new int[N][M];
		
		int midN = N/2;
		int midM = M/2;
		
		for(int i = 0; i < midN; i++) 
			for(int j = 0; j < midM; j++) 
				newArr[i][j+midM] = arr[i][j];
			
		
		for(int i = midN; i <N; i++) 
			for(int j = 0; j < midM; j++) 
				newArr[i-midN][j] = arr[i][j];

		for(int i = 0; i < midN; i++)
			for(int j = midM; j < M; j++)
				newArr[i+midN][j] = arr[i][j];
		
		for(int i = midN; i < N; i++) 
			for(int j = midM; j < M; j++)
				newArr[i][j-midM] = arr[i][j];
		
		arr = newArr;
		
	}
	
	static void antiClockwise() {
		int N = arr.length;
		int M = arr[0].length;
		int[][] newArr = new int[N][M];
		
		int midN = N/2;
		int midM = M/2;
		
		for(int i = 0; i < midN; i++) 
			for(int j = 0; j < midM; j++) 
				newArr[i+midN][j] = arr[i][j];
			
		
		for(int i = midN; i <N; i++) 
			for(int j = 0; j < midM; j++) 
				newArr[i][j+midM] = arr[i][j];

		for(int i = 0; i < midN; i++)
			for(int j = midM; j < M; j++)
				newArr[i][j-midM] = arr[i][j];
		
		for(int i = midN; i < N; i++) 
			for(int j = midM; j < M; j++)
				newArr[i-midN][j] = arr[i][j];
		
		arr = newArr;
	}
}