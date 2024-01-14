
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        boolean[][] board = new boolean[N][M];
        String str;
        for(int i = 0; i < N; i++){
            str = sc.next();
            for(int j = 0; j < M; j++){
                if (str.charAt(j) == 'B'){
                    board[i][j] = true;
                }
                else {
                    board[i][j] = false;
                }
            }
        }
        int max_N = N-7;
        int max_M = M-7;
        int count;
        int min_value = 65;
        boolean boardValue = true;
        
        for(int i = 0; i<max_N; i++){
            for(int j=0; j<max_M; j++){
                count = 0;
                boardValue = board[i][j];
                
                for(int a = i; a<i+8;a++) {
                	for(int b = j; b<j+8; b++) {
                		if(board[a][b] == boardValue)
                			count++;
                		boardValue = !(boardValue);
                	}
                    boardValue = !(boardValue);
                }
                min_value = Math.min(min_value, Math.min(count, 64-count));
            }

        }
        System.out.println(min_value);

        sc.close();
	}

}
