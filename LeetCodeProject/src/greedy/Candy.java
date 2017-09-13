package greedy;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors. What is the minimum candies you must give?
 * 
 * @author hgf
 *
 */

import java.util.Random;
public class Candy {
	
	public static void main(String[] args) {
		Random ran = new Random();
		Candy c = new Candy();
		int[] ratings = {1, 2, 2}; //{7,2,7,0,5,5,2,8,1,9,0,1,9,9,7,9,4,6,0,0};
//		for (int i = 0; i < ratings.length; i++) {
//			ratings[i] = ran.nextInt(10);
//			System.out.print(ratings[i] + ",");
//		}
//		System.out.println();
		System.out.println(c.candy(ratings));
	}
	
	public int candy(int[] ratings) {
		int[] candy = new int[ratings.length];
		recuresiveCandy(ratings, candy, 0, ratings.length - 1);
		int sum = 0;
		for (int i = 0; i < candy.length; i++) {
			sum += candy[i];
		}
		for (int i = 0; i < candy.length; i++) {
			System.out.print(candy[i] + ",");
		}
		System.out.println();
		return sum;
	}
	
	public void recuresiveCandy(int[] ratings, int[] candy, int start, int end) {
		if (start > end)
			return;
		int middle = findMin(ratings, start, end);
		setMin(ratings, candy, middle);
		recuresiveCandy(ratings, candy, start, middle - 1);
		recuresiveCandy(ratings, candy, middle + 1, end);
	}
	
	// 找到数组从start到end的最小值，包括start和end位置
	public int findMin(int[] ratings, int start, int end) {
		int min = ratings[start];
		int pos = start;
		for (int i = start; i <= end; i++) {
			if (min > ratings[i]) {
				pos = i;
				min = ratings[i];
			}
		}
		return pos;
	}
	
	public void setMin(int[] ratings, int[] candy, int pos) {
		if (pos > 0 && pos < candy.length - 1) {
			int tmpPos = pos - 1;
			if (ratings[pos - 1] > ratings[pos + 1])
				tmpPos = pos + 1;
			if (ratings[pos] == ratings[pos - 1] ||
					ratings[pos] == ratings[pos + 1])
				candy[pos] = candy[tmpPos];
			else 
				candy[pos] = Math.max(candy[pos - 1], candy[pos + 1]) + 1;
		}
		else if (pos > 0) {
			if (ratings[pos] == ratings[pos - 1])
				candy[pos] = candy[pos - 1];
			else
			candy[pos] = candy[pos - 1] + 1;
		}
		else if (pos < candy.length - 1) {
			if (ratings[pos] == ratings[pos + 1])
				candy[pos] = candy[pos + 1];
			else
				candy[pos] = candy[pos + 1] + 1;
		}
		else {
			candy[pos] = 1;
		}
	}
}
