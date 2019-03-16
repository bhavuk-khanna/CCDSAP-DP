package codingninjas_DP;

public class LCS {
	
	public static int lcs(String s1,String s2) {
		
		if(s1.length()==0||s2.length()==0)
			return 0;
		
		//case 1
		if(s1.charAt(0)==s2.charAt(0)) {
			return 1+lcs(s1.substring(1),s2.substring(1));
		}
		else {
			int op1 = lcs(s1,s2.substring(1));
			int op2 = lcs(s1.substring(1),s2);
			
			return Math.max(op1, op2);
		}
		
	}
	public static void main(String args[]) {
		String s1 = "abegi";
		String s2 = "adgei";
		
		System.out.println(lcs(s1,s2));
		
	}
}
