
/**
 * File Name: L0066.java 
 * @author Jagadeesh Vasudevamurthy
 * @year 2022
 */
import java.util.Arrays;
/************************************************************
 * CUT AND PASTE ENTIRE FILE IN LEETCODE
 *************************************************************/
class SolutionL0066 { 
	//In LEETCODE SolutionL0066 changed to Solution
	//Nothing can be changed below
	//LEETCODE VERSION
	public int[] plusOne(int[] digits) {
		int [][] ans = new int [1] [] ;
		int [] work = {0} ;
		L0066 a = new L0066(digits,ans,work);
		return ans[0] ;
	}
}

class L0066 {
	private int[] a;
	private int[][] ans;
	private int[] work;
	//YOU CAN HAVE ANY NUMBER OF PRIVATE VARIABLES and FUNCTIONS
	
	L0066(int[] a, int[][] ans, int[] work) {
		this.a = a ;
		this.ans = ans ;
		this.work = work ;
		alg();
	} 

	/*-----------------  WRITE CODE BELOW ---------------------------------*/

	private void alg() {
		int n = a.length ;
		int[] result = a;
		for(int i = result.length-1; i >=0; i--){
			if(result[i]<9){
				result[i] +=1;
				ans[0] = result;
				break;
			}
			else{
				result[i] = 0;
				int[] res = new int[result.length+1];
				res[0] = 1;
				ans[0] = res;
		
			}
		}
		work[0] = result.length;
	}
	public static void main(String[] args) {
		int[] digits = { 9,9};
		SolutionL0066 solutionL0066 = new SolutionL0066();
		solutionL0066.plusOne(digits);
	}

}


// private void alg() {
// 		int n = a.length ;
// 		Long num;
        
// 		StringBuilder s = new StringBuilder(); 
// 		for (int i : a)
// 		{
// 			s.append(i);
// 		}       
//         num = Long.parseLong(s.toString());
//     		num += 1;

// 		ans[0] = String.valueOf(num).chars().map(c -> c-'0').toArray();

// }}