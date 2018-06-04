/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]
*/

public int maxProfit(int[] prices) {
    
    if(prices == null || prices.length < 2) return 0;
    int[] buy = new int[prices.length];
    int[] sell = new int[prices.length];
    
    for(int i = 0; i < prices.length; i++){

        //The first day, we can only buy
        if(i == 0){
            buy[i] = -prices[i];
        }

        //On the second day, we can either buy the day before or today.
        else if(i == 1){
            buy[i] = Math.max(buy[i-1], -prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }

        //For buying, we can factor in the best result from buying either the day before, or
        //buying the stock selling the stock two days before cooling down yesterday, and buy today.
        //We ensure that when we buy, we have factored in the cool down time restriction.

        //For selling, we want to see what is the best we can achieve by either selling yesterday, or 
        //selling today, and buying the stock with buy[i-1] (which has already factored in cooldown)
        else{
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
    }
    return sell[prices.length-1];
}