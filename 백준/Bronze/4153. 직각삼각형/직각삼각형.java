import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        while(true){
            st = new StringTokenizer(br.readLine());
            int[] num = new int[3];
            num[0] = Integer.parseInt(st.nextToken());
            num[1] = Integer.parseInt(st.nextToken());
            num[2] = Integer.parseInt(st.nextToken());
            
            if(num[0] == 0)
                return;
            
            Arrays.sort(num);
            if(Math.pow(num[0], 2) + Math.pow(num[1], 2) == Math.pow(num[2], 2))
                System.out.println("right");
            else
                System.out.println("wrong");
        }
    }
}