package assignment;

public class Shortest_subsequence {
	public static int solve(String S,String V){
		
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input. Input is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		 */
		return solve_rec(S.substring(0, 1),1,S,V);
	}
	public static int solve_rec(String curr,int index,String S,String V){
		
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input. Input is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		 */
		
		if(!V.contains(curr)) {
			
			System.out.println("V does not contains : "+ curr);
			return curr.length();
		}
		if(index>=S.length())
			return Integer.MAX_VALUE;
		System.out.println(curr+S.charAt(index));
		int op1 = solve_rec(curr+S.charAt(index), index+1, S, V);
		int op2= solve_rec(curr, index+1, S, V);
		
		return Math.min(op1, op2);
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "banana";
		String V = "anbnaanbaan";
		System.out.println(solve(S,V));
	}

}
