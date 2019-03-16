package codingninjas_DP;

public class Knapsack01 {
	public static int knapsackM(int[] weight,int value[],int maxWeight, int n) {
		
		int storage [][] = new int[weight.length][maxWeight+1];
		for (int i=0;i<weight.length;i++) {
			for(int j=0;j<maxWeight+1;j++)
				storage[i][j]=-1;
		}
		
		return knapsackM_internal(weight, value,storage, maxWeight, 0);
	
		
	}
	public static int knapsackM_internal(int[] weight,int[] value,int storage[][],int maxWeight,int index) {
		if(index>=weight.length) {
			return 0;
		}
		if(maxWeight==0) {
			storage[index][maxWeight]=0;
			return storage[index][maxWeight];
		}
		
		if(storage[index][maxWeight]!=-1)
			return storage[index][maxWeight];
		int currw = weight[index];
		int currv = value[index];
		
		int op1=Integer.MIN_VALUE;
		if(currw<=maxWeight) {
			op1 = currv+knapsackM_internal(weight, value, storage, maxWeight-currw, index+1);
		}
		int op2 = knapsackM_internal(weight, value,storage, maxWeight, index+1);
		
		storage[index][maxWeight]= Math.max(op1, op2);
		return storage[index][maxWeight];
	}
	
	public static int knapsack(int[] weight,int value[],int maxWeight, int n){
		
		/* Your class should be named Solution.
		* Don't write main() function.
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/	
		
		return knapsack_recusive(weight,value,maxWeight,0);
		
	}
	
	public static int knapsack_recusive(int[] weight,int[]value,int maxWeight,int index) {
		
		
		if(maxWeight==0||index>=weight.length) {
			return 0;
		}
		
		int currw = weight[index];
		int currv = value[index];
		
		int op1=Integer.MIN_VALUE;
		if(currw<=maxWeight) {
			op1 = currv+knapsack_recusive(weight, value, maxWeight-currw, index+1);
		}
		int op2 = knapsack_recusive(weight, value, maxWeight, index+1);
		
		return Math.max(op1, op2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int weight[] = {23,31,29,44,53,38,63,85,89,82};
		int value[] = {92,57,49,68,60,43,67,84,87,72};
		
		System.out.println(knapsackM(weight, value, 165, 5));
	}

}
