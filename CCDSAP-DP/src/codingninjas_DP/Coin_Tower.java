package codingninjas_DP;

public class Coin_Tower {
	public static String solve(int n,int x,int y){
		
		// Write your code here .
		return Beerus(n,x,y);
	}
	
	public static String Beerus(int n,int x,int y){
		
		if(n-1==0||n-x==0||n-y==0) {
			return "Beerus";
		}
	
		String op1 = Whis(n-1,x,y);
		
		String op2= "";
		if(n-x>0)
			op2 = Whis(n-x,x,y);
		String op3 ="";
		if(n-y>0)
			op3 = Whis(n-y,x,y);
		
		if(op1.equals("Beerus")||op2.equals("Beerus") ||op3.equals("Beerus")) {
			return "Beerus";
		}
		else 
			return "Whis";
		
		
		
	}	
	public static String Whis(int n,int x,int y){
		
		if(n-1==0||n-x==0||n-y==0) {
			return "Whis";
		}
	
		String op1 = Beerus(n-1,x,y);
		
		String op2= "";
		if(n-x>0)
			op2 = Beerus(n-x,x,y);
		String op3 ="";
		if(n-y>0)
			op3 = Beerus(n-y,x,y);
		
		if(op1.equals("Whis")||op2.equals("Whis") ||op3.equals("Whis")) {
			return "Whis";
		}
		else 
			return "Beerus";
		
		
		
	}	

	public static  String solve_dp(int n,int x,int y){
		
		// Write your code here .
		String storage[] = new String[n+1];
		storage[1] ="Win";
		for(int i=2;i<storage.length;i++) {
			if(i==x||i==y) 
				storage[i]="Win";
			else {
				String op1 = storage[i-1];
				String op2="";
				String op3="";
				if(n-x>0)
					op2= storage[i-x];
				if(n-y>0)
					op3 = storage[i-y];
				if(op1.equals("Lose")||op2.equals("Lose")||op3.equals("Lose"))
					storage[i]="Win";
				else
					storage[i]="Lose";
			}
				
			}
		if(storage[n].equals("Win"))
			return "Beerus";
		else
			return "Whis";
		
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solve_dp(50,2,3));
		System.out.println(solve(50,2,3));
		
		
	}

}
