import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import javax.lang.model.type.ArrayType;
import javax.lang.model.util.ElementScanner6;

/**
 * File Name: duplicateN.java 
 *
 * To Compile: IntUtil.java RandomInt.java duplicateN.java duplicateNTest.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2021
 */

/************************************************************
 * Nothing can be changed in class duplicateN
 *************************************************************/
class duplicateN {
	int[] a; // a[i] guaranteed > 0 && < n-1
	// contents of a should be exactly like the original after your algorithms
	private String algName;
	private int[] numDup;
	private double[] work;
	private boolean show; // show only is show = true

	duplicateN(int[] a, String algName, int[] numDup, double[] work, boolean show) {
		this.a = a;
		this.algName = algName;
		this.numDup = numDup;
		this.work = work;
		this.show = show;
		AlgduplicateN b = new AlgduplicateN(this, algName, show);
	}

	public int size() {
		return a.length;
	}

	public int getI(int i) {
		work[0]++;
		return a[i];
	}

	public void setI(int i, int v) {
		work[0]++;
		a[i] = v;
	}

	public void setnumDup(int v) {
		numDup[0] = v;
	}
}

/************************************************************
 * WRITE CLASS AlgduplicateN
 * YOU CAN HAVE ANY NUMBER OF PRIVATE VARIABLES and FUNCTIONS
 *************************************************************/
class AlgduplicateN {
	private duplicateN f;
	private String algName;
	private boolean show; // show only is show = true

	AlgduplicateN(duplicateN f, String algName, boolean show) {
		// NOTHING CAN BE CHANGED HERE
		this.f = f;
		this.show = show;

		if (algName == "NsquareTimeConstantSpace") {
			alg_nsquare_time_constant_space();
		} else if (algName == "NTimeNSpace") {
			// alg_nsquare_time_constant_space();
			alg_ntime_n_space();
		} else if (algName == "NTimeConstantSpace") {
			// alg_nsquare_time_constant_space();
			alg_ntime_constant_space();
		}
	}

	/*
	 * Time complexity O(n^2)
	 * Space Complexity O(1)
	 */
	private void alg_nsquare_time_constant_space() {

		int count = 0;
		boolean isDuplicate;
		int arraylength = f.size();
		if (show) {
            System.out.print("Duplicate (");
        }
		for (int i = 0; i < arraylength; i++) {
			isDuplicate = false;
			int occur = 1;

			for (int j = i + 1; j < arraylength; j++) {
				if (f.getI(i) == f.getI(j)) {
					isDuplicate = true;
					occur++;
				}
			}
			if (occur == 2 && isDuplicate == true) {
				count++;
				if (show) {
					System.out.println(f.getI(i)+ " ");

				}
			}
		}
		if(show){
			System.out.println(")");
			System.out.println("Number of duplicate element in array:" +count);
		}
	}
	/*
	 * Time complexity O(n)
	 * Space Complexity O(n)
	 */
	private void alg_ntime_n_space() {
		int arraylength = f.size();
        if(show) {
            System.out.print("Duplicate (" );
        }

        int[] num = new int[arraylength];
        for(int i = 0; i < arraylength; i ++) {
            num[i] = f.getI(i);
        }

        for(int i = 0; i < arraylength; i ++) {
            int index = Math.abs(num[i] % arraylength);
            int value = num[index] + arraylength;
            if(value >= 3 * arraylength) {
                continue;
            } 
            else {
                num[index] = value;
            }
        }
        int count1 = 0;
        for(int i = 0; i < arraylength; i ++) {
            if((num[i] / arraylength) >= 2) {
                count1 ++;
                if(show) {
                    System.out.print(i+ " ");
                }
            }
        }
        if(show) {
            System.out.println(")");
            System.out.println("Number of duplicate element in array:" + count1);
        }
    }
	/*
	 * Time complexity O(n)
	 * Space Complexity O(1)
	 */
	private void alg_ntime_constant_space() {

		int arraylength = f.size();
        int count2 = 0;
        if (show) {
            System.out.print("Duplicate (");
        }

        for(int i = 0; i < arraylength; i ++) {
            int index = (f.getI(i) % arraylength);
            int value = Math.abs(f.getI(index) + arraylength);
            if(value >= 3 * arraylength) {
                continue;
            }
            else {
                f.setI(index, value);
            }
        }
        for(int i = 0; i < arraylength; i ++) {
            if((f.getI(i) / arraylength) >= 2) {
                count2 ++;
                if(show) {
                    System.out.print(i+ " ");
                }
            }
        }
        for(int i = 0; i < arraylength; i ++) {
            if(f.getI(i) >= arraylength){
                int value = Math.abs(f.getI(i) % arraylength);
                f.setI(i, value);
            }
        }
        if (show) {
            System.out.println(")");
            System.out.println("Number of duplicate element in array:" + count2);
			//System.out.println("-------------------------------\n");
        }
	}

	// private int getValue(int v, int aL) {
	// 	while (v < 0) {
	// 		v += aL;
	// 	}
	// 	;
	// 	return v % aL;
	// }

	public static void main(String[] args) {

		System.out.println("Run duplicateNTest.java");
	}
}