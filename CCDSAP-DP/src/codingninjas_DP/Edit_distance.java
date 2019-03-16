package codingninjas_DP;

public class Edit_distance {
	public static int ED(String s1, String s2) {
		if(s1.length()==0&&s2.length()==0)
			return 0;
		if(s1.length()==0) {
			return s2.length();
		}
		if(s2.length()==0)
			return s1.length();
		if(s1.charAt(0)==s2.charAt(0)) {
			return ED(s1.substring(1),s2.substring(1));
			
		}
		else {
			
			//insert
			int op1 = 1+ED(s1,s2.substring(1));
			//delete
			int op2 = 1+ ED(s1.substring(1),s2);
			//subsitutue
			int op3 = 1+ED(s1.substring(1),s2.substring(1));
			return Math.min(op1,Math.min(op2,op3));
		}
		
	}
	public static int EDM_internal(String s1,String s2, int storage[][]) {
		int m = s1.length();
		int n = s2.length();
		if(storage[m][n]!=-1)
			return storage[m][n];
		if(s1.length()==0&&s2.length()==0) {
			storage[m][n]=0;
			return storage[m][n];
					
		}
			
		if(m==0) {
			storage[m][n]=n;
			return storage[m][n];
		}
		if(s2.length()==0) {

			storage[m][n]=m;
			return storage[m][n];
		}
		if(s1.charAt(0)==s2.charAt(0)) {
			storage[m][n]= EDM_internal(s1.substring(1),s2.substring(1),storage);
			return storage[m][n];
		}
		else {
			
			//insert
			int op1 = 1+EDM_internal(s1,s2.substring(1),storage);
			//delete
			int op2 = 1+ EDM_internal(s1.substring(1),s2,storage);
			//subsitutue
			int op3 = 1+EDM_internal(s1.substring(1),s2.substring(1),storage);
			storage[m][n]= Math.min(op1,Math.min(op2,op3));
			return storage[m][n];
		}
		
		
	}
	public static int EDM(String s1,String s2) {
		int m = s1.length();
		int n = s2.length();
		int storage[][] = new int [m+1][n+1];
		for(int i=0;i<m+1;i++) {
			for(int j=0;j<n+1;j++) {
				storage[i][j]=-1;
			}
		}
		
		return EDM_internal(s1,s2,storage);
		
	}
	
	public static int ED_DP(String s1,String s2) {
		int m =s1.length();
		int n = s2.length();
		int storage[][] = new int[m+1][n+1];
		storage[0][0] = 0;
		for(int i=1;i<n+1;i++) {
			storage[0][i]= i;
		}
		for(int i=1;i<m+1;i++) {
			storage[i][0]= i;
		}
		
		for(int i=1;i<m+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(s1.charAt(m-i)==s2.charAt(n-j)) {
					storage[i][j]=storage[i-1][j-1];
				}
				else {
					int op1 = 1+ storage[i-1][j];
					int op2 = 1+storage[i][j-1];
					int op3 = 1+storage[i-1][j-1];
					storage[i][j]= Math.min(op1, Math.min(op2, op3));
				}
			}
		}
		
		return storage[m][n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		String s1= "sayugyusaiuqoioqwisoiqbnoi";
		String s2 = "bcqbuibiquwbiewbhqaiaom";
		System.out.println(ED_DP(s1, s2));
		System.out.println(EDM(s1,s2));
		System.out.println(ED(s1,s2));
	}

}
