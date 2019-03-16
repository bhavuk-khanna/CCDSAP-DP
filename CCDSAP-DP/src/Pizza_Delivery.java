import java.util.ArrayList;
import java.util.Arrays;

class Solve{
	public int find_min(ArrayList<Integer>list) {
		int min = Integer.MAX_VALUE;
		for(int i=0;i<list.size();i++) {
			if(list.get(i)<min)
				min=list.get(i);
		}
		return min;
	}
	public int find_max(int[]arr) {
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max)
				max=arr[i];
		}
		
		return max;
	}
	public boolean binary_search(int[]arr,int si,int ei,int x) {
		if(si>ei)
			return false;
		if(si==ei) {
			if(arr[si]==x)
				return true;
			else
				return false;	
		}
		int mid = (ei+si)/2;
		if(arr[mid]==x)
			return true;
		else if(arr[mid]<x)
			return binary_search(arr, mid+1, ei, x);
		else
			return binary_search(arr, si, mid-1, x);
	}
	public int solve(int dist[],int fuel[]) {
		int max = find_max(dist);
		max=2*max;
		Arrays.sort(fuel);
		int out[]=new int[max+1];
		for(int i=0;i<out.length;i++) {
			out[i]=Integer.MAX_VALUE;
		}
		//print fuel to check if correctly sorted
		for(int i=1;i<out.length;i++) {
			if(binary_search(fuel, 0, fuel.length-1, i)) {
				out[i]=1;
			}
			else {
				int j=0;
				ArrayList<Integer> list = new ArrayList<>();
				while(j<fuel.length&&fuel[j]<i) {
					//System.out.println(i-fuel[j]);
					if(out[i-fuel[j]]==Integer.MAX_VALUE)
						list.add(Integer.MAX_VALUE);
					else {
						list.add(1+out[i-fuel[j]]);
						
					}
					j++;	
				}
				out[i]=find_min(list);
			}
		}
		int min_steps=0;
		for(int i=0;i<dist.length;i++) {
			min_steps+=out[2*dist[i]];
		}
		return min_steps;
	}
}
public class Pizza_Delivery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader in  = new FastReader();
		int T = in.nextInt();
		for(int i=0;i<T;i++) {
			int N = in.nextInt();
			int dist[] = new int[N];
			int fuel[]= new int[N];
			for(int j=0;j<N;j++) {
				dist[j]=in.nextInt();
			}
			for(int j=0;j<N;j++) {
				fuel[j]=in.nextInt();
			}
			//printing dist array
			
			System.out.println(new Solve().solve(dist, fuel));
		}
	}

}
