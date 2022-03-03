import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

/**
 * File Name: duplicateNTest.java 
 * Sum of N base class
 * 
 * To Compile: IntUtil.java RandomInt.java duplicateN.java duplicateNTest.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2021
 */

/*
 * YOU CANNOT CHANGE ANYTHING IN THIS FILE. READ ONLY
 */

class duplicateNTest{
	//input
	private int[] a ; //a[i] guaranteed > 0 && < n-1
	//contents of a should be exactly like the original after your algorithms
	private boolean show ; //show only is show = true
	private IntUtil u = new IntUtil();

	duplicateNTest() {
		testBed() ;
	}
   
  private void testBed() {
		simpleTests() ;
		randomTests() ;
		System.out.println("All test cases passed. You will get full grade now");
		System.out.println("Include only duplicateN.java and the output of this program for FULL grade");
	}	
  
  private void test1() {
  	if (show) {
  		System.out.println("----------------------------");
  		u.pLn(a.length) ;
      u.pLn(a);
  	}
  	int[] copya = u.copyArray(a);
  	int [] d0 = {-1} ; //Number of duplicates from alg 0
  	int [] d1 = {-1} ; //Number of duplicates from alg 1
  	int [] d2 = {-1} ; //Number of duplicates from alg 2
    {
    	long startTime = System.nanoTime();
    	double [] work0 = {0} ; //Work for alg 0
    	duplicateN da = new duplicateN(a,"NsquareTimeConstantSpace",d0,work0,show) ;
    	long endTime = System.nanoTime();
      double d = u.timeInSec(endTime,startTime) ;
      System.out.println("O(n^2)Time O(1)Space Alg.  n = " + a.length + " Work = " + work0[0]  + " CPU = " + d + " secs") ;  
      boolean  e = u.arrayEqual(a, copya);
      if (e == false) {
      	System.out.println("You changed the content of given array a") ;
      	u.myassert(false) ;
      }
      u.myassert(e);
    }
    {
    	long startTime = System.nanoTime();
    	double [] work1 = {0} ; //Work for alg 1
    	duplicateN da = new duplicateN(a,"NTimeNSpace",d1,work1,show) ;
    	long endTime = System.nanoTime();
      double d = u.timeInSec(endTime,startTime) ;
      System.out.println("O(n)Time O(n)Space Alg.    n = " + a.length + " Work = " + work1[0] + " CPU = " + d + " secs") ;  
      boolean  e = u.arrayEqual(a, copya);
      if (e == false) {
      	System.out.println("You changed the content of given array a") ;
      	u.myassert(false) ;
      }
      u.myassert(e);
      u.myassert(d1[0] == d0[0]);
    }
    {
    	long startTime = System.nanoTime();
    	double [] work2 = {0} ; //Work for alg 2
    	duplicateN da = new duplicateN(a,"NTimeConstantSpace",d2,work2,show) ;
    	long endTime = System.nanoTime();
      double d = u.timeInSec(endTime,startTime) ;
      System.out.println("O(n)Time O(1)Space Alg.    n = " + a.length +  " Work = " + work2[0] + " CPU = " + d + " secs") ;  
      boolean  e = u.arrayEqual(a, copya);
      if (e == false) {
      	System.out.println("You changed the content of given array a") ;
      	u.myassert(false) ;
      }
      u.myassert(e);
      u.myassert(d2[0] == d0[0]);
    }
  }
  
  private void simpleTests() {
  	show = true ;
  	{
      int b[] = { 1,1,1 }; 
      this.a = b ;
      test1();
    }
  	{
  		int b[] = { 1,0,0,0 };
  		this.a = b ;
      test1();
    }
    {
      int b[] = { 1,2,3,1,3,6,6 };
      this.a = b ;
      test1();
    }
    {
      int b[] = { 1,2,3,1,3,0,0 };
      this.a = b ;
      test1();
    }
    {
      int b[] = { 0,0,1 };
      this.a = b ;
      test1();
    }
    {
      int b[] = { 3,2,0,1 };
      this.a = b ;
      test1();
    }
    System.out.println("All simple tests passed");
  }
  
  private void randomTests() {
  	show = false ;
  	int N = 500000; //500000 500000
    for (int i = 10000; i < N; i = i + 10000) {
    	{
    	   a = new int[i];
    	   for (int j = 0; j < i; ++j) {
    	  	 a[j] = i - 1;
    	   }
    	   test1() ;
    	}
    	{
	    	int start = 0 ;
				int end = i-1 ; ;
				int [] b = u.generateRandomNumber(i, true, start,end);
				this.a = b ;
	      test1();
    	}
    }
    System.out.println(N + " Random tests passed");
  }
	
	public static void main(String[] args) {
			//Change path below
			String s = "/Users/rutuja/Desktop/Courses/INFO6205/HW3_DuplicateN/duplicateNoutput.txt";
			if (true) { //Make it to true to write to a file
				System.out.println("Writing to file" + s) ;
				try {
					System.setOut(new PrintStream(new FileOutputStream(s)));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		System.out.println("duplicateNTest.java STARTS");
		String version = System.getProperty("java.version");
		System.out.println("Java version used for this program is " + version);
		duplicateNTest m = new duplicateNTest();
		System.out.println("duplicateNTest.java ENDS");
	}
}