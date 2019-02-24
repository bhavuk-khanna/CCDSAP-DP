class Solver{
		
		public int[] solve(int arr[]) {
			int i=arr.length-2;
			int out[] = new int[arr.length]; 
			out[arr.length-1]=1;
			while(i>=0) {
				
				
				if((arr[i]>=0&&arr[i+1]<0)||(arr[i]<0&&arr[i+1]>=0)) 
					out[i]=1+out[i+1];
				else
					out[i]=1;
				
				i--;
			}
			
			
			return out;
	}
	}
public class Alternating_subarray_prefix {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader in = new FastReader();
		int T = in.nextInt();
		for(int i=0;i<T;i++) {
			int N =in.nextInt();
			int arr[] = new int[N];
			for(int j=0;j<N;j++)
				arr[j]=in.nextInt();
			int out[] = new Solver().solve(arr);
			for(int j=0;j<out.length;j++)
				System.out.print(out[j]+" ");
			System.out.println();
			
		}
		
		
		
	}

}
