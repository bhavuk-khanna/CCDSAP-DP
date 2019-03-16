package codingninjas_DP;

public class LCS_memoization {
	public static int lcs_memo(String s1,String s2, int out[][]) {
		
		if(s1.length()==0||s2.length()==0)
			return 0;

		if(out[s1.length()-1][s2.length()-1]!=-1) {
			return out[s1.length()-1][s2.length()-1];
		}
		if(s1.charAt(0)==s2.charAt(0)) {
			out[s1.length()-1][s2.length()-1]= 1+lcs_memo(s1.substring(1),s2.substring(1),out);
			return out[s1.length()-1][s2.length()-1];
		}
		else {
			int op1 = lcs_memo(s1,s2.substring(1),out);
			int op2 = lcs_memo(s1.substring(1),s2,out);
			
			out[s1.length()-1][s2.length()-1]= Math.max(op1, op2);
			return out[s1.length()-1][s2.length()-1];
		}
		
	}
	
	public static int lcs(String s1,String s2) {
		int out[][] = new int[s1.length()][s2.length()];
		for(int i=0;i<s1.length();i++) {
			for(int j=0;j<s2.length();j++) {
				out[i][j]=-1;
			}
		}
		
		
		return lcs_memo(s1, s2,out);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1= "abcdefgidsjkaakadsbhjiuqhihens";
		String s2 = "sdbbqbqbdisolialjwiiwdiwdnnwdl";
		System.out.println(lcs(s1, s2));
	}

}
