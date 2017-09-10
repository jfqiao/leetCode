package array;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * @author jfqiao
 *
 */
public class BestTimeToBuyAndSellStockIV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//由1到2， 在扩展到k次交易。
	public int maxProfit(int k, int[] prices) {
		for (int i = 0; i < prices.length - 1; i++) {
			prices[i] = prices[i + 1] - prices[i];
		}
		return 0;
	}
	
	//
		public int maxProfitWithTwoTrans(int[] prices, int start, int end) {
			
			int max = Integer.MIN_VALUE;
			int tmp;
			for (int i = start; i < end; i++) {
				if (prices[i] <= 0) {
					continue;
				}
				//从1到i一部分，从i+1到length - 1是另外一个部分，两部分求最大利润，相加即可得到两次结果。
			    tmp = maxSum(prices, start, i + 1) + maxSum(prices, i + 1, end);
				if (tmp > max)
					max = tmp;
			}
			tmp = maxSum(prices, start, end);
			if (max < tmp)
				max = tmp;
			return max;
		}
		
		public int maxSum(int[] nums, int start, int end) {
			int sum = 0;
			int tmpSum = 0;
			for (int i = start; i < end; i++) {
				tmpSum += nums[i];
				if (tmpSum < 0)
					tmpSum = 0;
				if (sum < tmpSum)
					sum = tmpSum;
			}
			return sum;
		}
}
