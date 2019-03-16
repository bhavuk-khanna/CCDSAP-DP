package codingninjas_DP;

public class LCS_dp {
	
	public static int lcs_dp(String s1, String s2) {
		
		int m = s1.length();
		int n = s2.length();
		int out[][] = new int[m+1][n+1];
		
		for(int i=0,j=0;j<n+1;j++) {
			out[i][j]=0;
		}
		for(int j=0,i=0;i<m+1;i++) {
			out[i][j]=0;
		}
		
		for(int j=1;j<n+1;j++) {
			for(int i=1;i<m+1;i++) {
				if(s1.charAt(s1.length()-i)==s2.charAt(s2.length()-j)){
					out[i][j]=1+out[i-1][j-1];
				}else {
					out[i][j]=Math.max(out[i-1][j],out[i][j-1]);
				}
				
			}
		}
		
		
		return out[m][n];
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 ="abcdefgidsjkaakadsbhjiuqhihens";
		String s2 = "sdbbqbqbdisolialjwiiwdiwdnnwdl";
		System.out.println(lcs_dp(s1, s2));
	}

}
