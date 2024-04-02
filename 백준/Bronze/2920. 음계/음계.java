import java.util.*;
import java.io.*;

class Main{
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] as = {1, 2, 3, 4, 5,6,7,8};
        int[] de = {8,7,6,5,4,3,2,1};
        
        boolean mixed = false;
        int num = Integer.parseInt(st.nextToken());
        if(num == as[0]){
            for(int i = 1; i < 8; i++){
                int input = Integer.parseInt(st.nextToken());
                if(as[i] != input){
                    mixed = true;
                    break;
                }
            }
        } else {
            for(int i = 1; i < 8; i++){
                int input = Integer.parseInt(st.nextToken());
                if(de[i] != input){
                    mixed = true;
                    break;
                }
            }
        }
        if(mixed){
         
            System.out.println("mixed");
            return;
        }
        if(num == 1)
            System.out.println("ascending");
        if(num == 8)
            System.out.println("descending");
    }
}