package assignment;

public class Loot_houses {
	public static int getMaxMoney(int arr[], int n){

		/*Your class should be named Solution. 
		*Don’t write main(). 
	 	*Don’t take input, it is passed as function argument.
	 	*Don’t print output.
	 	*Taking input and printing output is handled automatically.
		*/ 		
		return getMaxMoney_recursive(arr,0);
	}
	public static int getMaxMoney_recursive(int arr[], int index) {
		
		if(index>=arr.length)
			return 0;
		
		int op1 = arr[index]+getMaxMoney_recursive(arr, index+2);
		int op2 = getMaxMoney_recursive(arr, index+1);
		
		return Math.max(op1,op2);
		
		
}
public static int getMaxMoney_M(int arr[],int n) {
	int storage[] = new int[n];
	
	for(int i=0;i<n;i++) {
		storage[i]=-1;
	}
	return getMaxMoney_M_internal(arr,0,storage);
}	
	
public static int getMaxMoney_M_internal(int arr[],int index,int storage[]) {
	if(index>=arr.length)
		return 0;
	
	if(storage[index]!=-1)
		return storage[index];
	int op1 = arr[index]+getMaxMoney_M_internal(arr, index+2, storage);
	int op2 = getMaxMoney_M_internal(arr, index+1, storage);
	
	storage[index] =Math.max(op1,op2);
	return storage[index];
}

public static int getMaxMoney_dp(int arr[],int n) {
	
	int storage[] =new int[n];
	
	storage[n-1]= arr[n-1];
	storage[n-2]=Math.max(arr[n-2], storage[n-1]);
	for(int i=n-3;i>=0;i--) {
		
		storage[i] = Math.max(arr[i]+storage[i+2], storage[i+1]);
			
	}
	return storage[0];
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1412,6970,9998,1772,7156,4482,2153,8972,3811,902,6586,2988,1417,5124,2305,1344,6585,2881,6369,4089};
		System.out.println(getMaxMoney_dp(arr, arr.length));
	}

}
