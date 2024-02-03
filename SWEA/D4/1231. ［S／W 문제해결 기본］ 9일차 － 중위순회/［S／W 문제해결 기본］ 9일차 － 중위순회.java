import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static String[] graph;
	static int N;
	static StringBuilder sb = null;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		

		for(int tc = 1; tc < 11; tc++) {
			N = Integer.parseInt(br.readLine());
			graph = new String[N+1];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int vNum = Integer.parseInt(st.nextToken());
				String value = st.nextToken();
				graph[vNum] = value;
			}
			
			sb = new StringBuilder();
			sb.append("#" + tc + " ");
			inOrder(1);
			System.out.println(sb);
		}
	}
	
	static void inOrder(int vNum) {
		if(vNum > N)
			return;
		inOrder(vNum *2);
		sb.append(graph[vNum]);
		inOrder(vNum * 2 + 1);
	}
}