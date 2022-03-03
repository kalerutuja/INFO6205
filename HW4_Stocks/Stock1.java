/**
 * File Name: Stock1.java 
 * Stock1 concrete class
 * 
 * 
 * To Compile: IntUtil.java RandomInt.java Stock1.java Stock1Base.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2019
 */

class Stock1 extends Stock1Base{
	//You can have any number of private data members here
	//You can have any number of private functions here
	Stock1() {
		//NOTHING CAN BE CHANGED HERE
		testBed() ;
	}
	
	@Override
	void NSquareTimeConstantSpace() {
		//NOTHING CAN BE CHANGED HERE
    nsquareTimeConstantSpace() ;
	}
	
	@Override
  void NlognTimeLognSpace() {
		//NOTHING CAN BE CHANGED HERE
    nlognTimelognSpace() ;
	}
	
	@Override
  void NTimeLognSpace() {
		//NOTHING CAN BE CHANGED HERE
    nTimelognSpace() ;
	}
	
	@Override
	void NTimeConstantSpace() {
		nTimeConstantSpace();
	}
	
	/*
	 * Time: O(n^2)
	 * Space: THETA(1)
	 * All your routine should match this answer
	 * Nothing can be changed in this routine
	 */
	private void nsquareTimeConstantSpace() {
		int gp = 0 ;
		int l = size() ;
		for (int buy = 0; buy < l-1; ++buy) {
			for (int sell = buy + 1; sell < l; ++sell) {
				++numConquer;
				int p = profit(sell,buy);
				if (p >= gp) { //So that I can make profit by keeping stock for less time
					gp = p ;
					buyDay = buy ;
					sellDay = sell ;
				}
			}
		}
	}
	
	/*
	 * Time: O(nlogn)
	 * Space: O(logn)
	 */
	private void nlognTimelognSpace() {
	//must write the routine. UNTIL YOU WRITE UNCOMMENT BELOW
     //nsquareTimeConstantSpace(); 
		int l = size();
		nlognTimelognSpace(0, l-1);
	}
	private int max(int i, int j){
		return (i >j ? i:j);
	}
	private void nlognTimelognSpace(int min, int max) {
		if (min == max) {
			return;
		}
		numDivide++;
		int mid = (max-min)/2+min;
		nlognTimelognSpace(min, mid);
		nlognTimelognSpace(mid+1, max);
		int buy = min, sell = max;
		for(int b = min, s = max; b <= s; b++, s--) {
			numConquer++;
			if (price(b) < price(buy)) {
				buy = b;
			}
			if (price(s) > price(sell)) {
				sell = s;
			}
		}
		if (profit(sell, buy) > profit(sellDay, buyDay)) {
			sellDay = sell;
			buyDay = buy;
		}
	}

	/*
 	* Time: O(n)
 	* Space: O(logn)
	*/
	private void nTimelognSpace() {
	//must write the routine. UNTIL YOU WRITE UNCOMMENT BELOW
    //nsquareTimeConstantSpace();
		int l = size();
		int[] maxProfit = nTimelognSpace(0, l-1);
	}
	
	private int[] nTimelognSpace(int min, int max) {
		int[] maxProfit = {min, min};
		if (min == max) {
			return maxProfit;
		}
		numDivide++;
		numConquer++;
		int mid = (max-min)/2+min;
		int[] lp = nTimelognSpace(min, mid);
		int[] rp = nTimelognSpace(mid+1, max);
		if (profit(rp[1], lp[0]) > profit(sellDay, buyDay)) {
			sellDay = rp[1];
			buyDay = lp[0];
		}
		maxProfit[0] = price(lp[0]) < price(rp[0]) ? lp[0] : rp[0];
		maxProfit[1] = price(lp[1]) > price(rp[1]) ? lp[1] : rp[1];
		return maxProfit;
	}
	/*
 	* Time: O(n)
 	* Space: O(1)
 	*/
	private void nTimeConstantSpace() {
	//IF YOU CANNOT WRITE  USE THE ROUTINE BELOW
    //nsquareTimeConstantSpace();
		int buy = 0;
		int l = size();
		for(int i = 1; i < l; i++) {
			numConquer++;
			if (price(i) < price(buy)) {
				buy = i;
			} else if (profit(i, buy) > profit(sellDay, buyDay)) {
				sellDay = i;
				buyDay = buy;
			}
		}
	}
	
	public static void main(String[] args) {
		//NOTHING CAN BE CHANGED HERE
		System.out.println("Stock1 problem STARTS");
		Stock1 m = new Stock1() ;
		System.out.println("All Stock1 tests passed. Now you can pass interviews");
		System.out.println("Stock1 problem ENDS");
	}
}
