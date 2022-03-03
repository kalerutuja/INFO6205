import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * File Name: L0066Test.java 
 * @author Jagadeesh Vasudevamurthy
 * @year 2022
 */

/************************************************************
		NOTHING CAN BE CHANGED IN THIS FILE
 *************************************************************/
class L0066Test {
	private boolean show = true ; 
	private IntUtil u = new IntUtil() ;
	private int count = 0 ;
	L0066Test() {
		testBed() ;
	}

	private void testBed() {
		tests() ;
	}
	

	private void testOne(int[] n, int[] e) {
		int [][] ans = new int [1] [] ;
		int [] work = {0} ;
		L0066 a = new L0066(n,ans,work);

		if (show) {
			System.out.println("------------Problem " + ++count +  " -----------------");
			System.out.println("length of input = " + n.length) ;
			u.pLn(n);
			u.pLn(ans[0]);
			System.out.println("work = " + work[0]);
		}
		int el = e.length ;
		int al = ans[0].length ;
		if (el != al) {
			System.out.println("Your ans length = " + al +  " But expected length = " + el);
			u.myassert(false);
		}
		for (int i = 0; i < el; ++i) {
			if (e[i] != ans[0][i]) {
				System.out.println("e[" + i + "]=" +  e[i] + " But ans[0][" + i + "]=" + ans[0][i]);
				u.myassert(false);
			}
		}
		if (work[0] == 0) {
			System.out.println("How did you solve problem in 0 steps") ;
			u.myassert(false);
		}
	}
 
  
	private void tests() {
		{
			int a[] = { 1};
			int e[] = {2};
			testOne(a, e);
		}
		{
			int a[] = { 9};
			int e[] = { 1, 0};
			testOne(a, e);
		}
		{
			int a[] = { 1, 2, 3 };
			int e[] = { 1, 2, 4 };
			testOne(a, e);
		}
		{
			int a[] = { 9,8,9};
			int e[] = {9,9,0};
			testOne(a, e);
		}
		{
			int a[] = { 1, 7, 8, 9 };
			int e[] = { 1, 7, 9, 0 };
			testOne(a, e);
		}

		{
			int a[] = { 9, 9 };
			int e[] = { 1, 0, 0 };
			testOne(a, e);
		}
		{
			int a[] = { 9, 9, 8 };
			int e[] = { 9, 9, 9 };
			testOne(a, e);
		}
		{
			int a[] = { 9, 9, 9,9,9,9,9, 9, 9,9,9,9,9, 9, 9,9,9,9,9, 9, 9,9,9,9,8 };
			int e[] = { 9, 9, 9,9,9,9,9, 9, 9,9,9,9,9, 9, 9,9,9,9,9, 9, 9,9,9,9,9};
			testOne(a, e);
		}
		{
			int a[] = { 9, 9, 9,9,9,9,9, 9, 9,9,9,9,9, 9, 9,9,9,9,9, 9, 9,9,9,9,9 };
			int e[] = {1, 0, 0, 0,0,0,0,0, 0, 0,0,0,0,0, 0, 0,0,0,0,0, 0, 0,0,0,0,0};
			testOne(a, e);
		}
		{
			int a[] = { 9, 9, 9,9,9,9,9, 9, 9,9,9,9,9, 9, 9,9,9,9,9, 9, 9,9,9,9,9,9, 9, 9,9,9,9,9, 9, 9,9,9,9,9, 9, 9,9,9,9,9, 9, 9,9,9,9,9 };
			int e[] = {1,0, 0, 0,0,0,0,0, 0, 0,0,0,0,0, 0, 0,0,0,0,0, 0, 0,0,0,0,0,0, 0, 0,0,0,0,0, 0, 0,0,0,0,0, 0, 0,0,0,0,0, 0, 0,0,0,0,0 };
			testOne(a, e);
		}
	}

	public static void main(String[] args) {
		//Change path below
		//String s = "C:\\Users\\jag\\OneDrive\\vasu\\work\\leetcode\\L0066Plusone\\java11\\s\\L0066output.txt";
		String s = "/Users/rutuja/Desktop/Courses/INFO6205/HW2_66_Plus_One/L0066output.txt";
		if (true) { //Make it to true to write to a file
			System.out.println("Writing to file" + s) ;
			try {
				System.setOut(new PrintStream(new FileOutputStream(s)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("L0066 problem STARTS");
		L0066Test m = new L0066Test();
		System.out.println("Attach output file " + s) ;
		System.out.println("RUN NOW at: https://leetcode.com/problems/plus-one/") ;
		System.out.println("L0066 problem ENDS");
	}
}
