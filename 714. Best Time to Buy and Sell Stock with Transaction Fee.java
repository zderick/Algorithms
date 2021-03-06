/*
Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Note:

0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.
*/

//O(n) time, O(n) space
public int maxProfit(int[] prices, int fee) {
	int[] buy = new int[prices.length];
	Arrays.fill(buy, Integer.MIN_VALUE);

	int[] sell = new int[prices.length];

	for(int i = 0; i < prices.length; i++){
		if(i == 0){
			buy[i] = -prices[i] - fee;
		}
		else{
			buy[i] = Math.max(buy[i-1], sell[i-1]- prices[i] - fee);
			sell[i] = Math.max(sell[i-1], prices[i] + buy[i-1]);
		}
	}
	return sell[prices.length-1];
}


//O(n) time, O(1) space
public int maxProfit(int[] prices, int fee) {
	int sell = 0;
	int buy = Integer.MIN_VALUE;

	for(int i = 0; i < prices.length; i++){
		int prevSell = sell;
		sell = Math.max(sell, buy + prices[i]);
		buy = Math.max(buy, prevSell - prices[i] - fee);
	}

	return sell;
}