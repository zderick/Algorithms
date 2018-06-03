/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
*/

public int maxProfit(int k, int[] prices) {
    if(prices == null || prices.length < 2 || k == 0) return 0;
    
    k = Math.min(k, prices.length);

    int[] buy = new int[k];
    int[] sell = new int[k];

    Arrays.fill(buy, Integer.MIN_VALUE);

    for(int i = 0; i < prices.length; i++){
        for(int j = 0; j < k; j++){
            if(j == 0){
                buy[j] = Math.max(buy[j], -prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
            else{
                buy[j] = Math.max(buy[j], sell[j-1]-prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
    }
    return sell[k-1];
}