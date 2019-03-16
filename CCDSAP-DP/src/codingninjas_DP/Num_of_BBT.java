package codingninjas_DP;

public class Num_of_BBT {
	public static int mod=(int)Math.pow(10, 9)+7; 
	
	public static int balancedTreesOfHeightH(int height){
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
		int arr[] =new int[height+1];
		arr[0]=1;
		arr[1]=1;
		arr[2]=3;
		for(int i=3;i<=height;i++) {
			int x = arr[i-1];
			int y = arr[i-2];
			long res1=(long)x*x;
			System.out.println("Res1 :"+res1);
			long res2 = (long)x*y*2;
			System.out.println("Res1 :"+res2);
			int value1 =(int) (res1%mod);
			System.out.println("Value1 :"+value1);
			int value2 = (int)(res2%mod);
			System.out.println("Value2 :"+value2);
			int result = ((value1%mod)+(value2%mod))%mod;
			System.out.println("result :"+result);
			arr[i]=result;
		}
		return  arr[height];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader in = new FastReader();
		System.out.println(balancedTreesOfHeightH(7));
		
	}

}
