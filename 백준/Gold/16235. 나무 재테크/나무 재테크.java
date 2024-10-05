import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
	static int[] dy = {1, -1, -1, 0, 1, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {

		int N, M, K;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] land = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				land[i][j] = 5;
			}
		}
		
		Deque<Integer>[][] trees = new LinkedList[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				trees[i][j] = new LinkedList<Integer>();
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int year = Integer.parseInt(st.nextToken());
			
			trees[x][y].add(year);
		}
		
		for(int k = 0; k < K; k++) {
			print(land);
			
			// spring
			int[][] dead = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int cnt = trees[i][j].size();
					for(int l = 0; l < cnt; l++) {
						int cur = trees[i][j].pollFirst();
						if(land[i][j] >= cur) {
							land[i][j] -= cur;
							cur++;
							trees[i][j].addLast(cur);
						} else {
							dead[i][j] += cur/2;
						}
					}
				}
			}
			
			//summer	
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					land[i][j] += dead[i][j];
				}
			}
//			System.out.println("summer");
			print(land);
			//fall
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					for(int l = 0; l < trees[i][j].size(); l++) {
						int cur = trees[i][j].pollFirst();
						if(cur % 5 == 0) {
							for(int d = 0; d < 8; d++) {
								int ni = i + dx[d];
								int nj = j + dy[d];
								
								if(0 <= ni && ni < N && 0 <= nj && nj < N)
									trees[ni][nj].addFirst(1);
							}
						}
						trees[i][j].addLast(cur);
					}
				}
			}
			
			// winter
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					land[i][j] += A[i][j];
				}
			}
		}
		
		int alive = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				alive += trees[i][j].size();
			}
		}
		
		System.out.println(alive);
	}
	static void print(int[][] map) {
//		for(int i = 0; i < map.length; i++) {
//			for(int j = 0; j < map[0].length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("-----------------");
	}
}