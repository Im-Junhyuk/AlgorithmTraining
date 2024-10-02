import java.util.*;
import java.io.*;

class Solution {
    
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));
        
        while(!q.isEmpty()){
            Point curP = q.poll();
            int curX = curP.x;
            int curY = curP.y;
            int curDist = curP.dist;
            
            if(visited[curX][curY])
                continue;
            visited[curX][curY] = true;
            
            if(curX == n-1 && curY == m-1){
                return curDist;
            }
            
            for(int d = 0; d < 4; d++){
                int nX = curX + dx[d];
                int nY = curY + dy[d];
                int nDist = curDist + 1;
                
                if(nX < 0 || nX >= n || nY < 0 || nY >= m || visited[nX][nY] || 
                  maps[nX][nY] == 0)
                    continue;
                
                q.add(new Point(nX, nY, nDist));
            }
        }
        return -1;
    }
    
    class Point{
        int x;
        int y;
        int dist;
        Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}