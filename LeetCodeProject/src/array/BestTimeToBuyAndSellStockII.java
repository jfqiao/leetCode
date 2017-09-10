package array;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 * 
 * 
 * @author jfqiao
 *
 */
public class BestTimeToBuyAndSellStockII {
	
	//利用后一天减去前一天的价格，直接加上所有的正值即可。
	public int maxProfit(int[] prices) {
        for (int i = 0; i < prices.length - 1; i++) {
        	prices[i] = prices[i + 1] - prices[i];
        }
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
        	if (prices[i] > 0)
        		sum += prices[i];
        }
		return sum;
    }
	
	//找到所有的递增序列即可，利用递增序列最后一个数减去第一个数得到序列差值
	public int maxProfit2(int[] prices) {
		int start = 0;
		int end = 0;
		int sum = 0;
		for (int i = 0; i <= prices.length - 1; i++) {
			if (prices[i] > prices[end])
				end++;
			else {
				sum += prices[end] - prices[start];
				start = i;
				end = i;
			}
		}
		if (prices[end] > prices[start])
			sum += prices[end] - prices[start];
		return sum;
	}
}
