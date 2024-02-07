import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Heap heap = new Heap(N);
		StringBuilder sb = new StringBuilder();
		
		for(int n = 0; n < N; n++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				sb.append(heap.pop())
				.append("\n");
			} else {
				heap.push(input);
			}
		}
		
		System.out.println(sb);
	}

	static class Heap{
		int[] arr;
		int last;
		
		Heap(int N){
			arr = new int[N];
			last = -1;
		}
		
		void push(int input) {
			last++;
			arr[last] = input;
			
			int cur = last;
			
			while(cur > 0) {
				int parent = (cur-1)/2;
				if(Math.abs(arr[cur]) > Math.abs(arr[parent]))
						break;
				
				if(Math.abs(arr[cur]) < Math.abs(arr[parent])) {
					int temp = arr[parent];
					arr[parent] = arr[cur];
					arr[cur] = temp;
					
					cur = parent;
					continue;
					
				} else { // have same abs v
					if(arr[cur] < arr[parent]) {
						int temp = arr[parent];
						arr[parent] = arr[cur];
						arr[cur] = temp;
						
						cur = parent;
						continue;
					} else
						break;
				}
					
			}
		}
		
		int pop() {
			if(last == -1)
				return 0;
			
			int returnV = arr[0];
			arr[0] = arr[last];
			int cur = 0;
			last--;
			
			while(cur * 2 + 2 <= last) {
				int left = cur * 2 + 1;
				int right = cur * 2 + 2;
				int child;
				
				if(Math.abs(arr[left]) < Math.abs(arr[right])) 
					child = left;
				else if(Math.abs(arr[left]) > Math.abs(arr[right])) 
					child = right;
				else if(arr[left] <= arr[right])
					child = left;
				else
					child = right;
				
				if(Math.abs(arr[cur]) < Math.abs(arr[child]))
					break;
				else if(Math.abs(arr[cur]) > Math.abs(arr[child])) {
					int temp = arr[child];
					arr[child] = arr[cur];
					arr[cur] = temp;
					cur = child;
					continue;
				} else if(arr[cur] <= arr[child])
					break;
				else {
					int temp = arr[child];
					arr[child] = arr[cur];
					arr[cur] = temp;
					cur = child;
					continue;
				}
					
			}
			
			return returnV;
		}
	}
}