/**
 * Problem discribe:
 * Given an integer n, return 1 - n in lexicographical order(字典顺序）.
 * 
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * 
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 * 
 * 按字典顺序输出数字。
	 * 思路：迭代或递归暂时可以解决。
	 * 已知第i个数为ai,
	 * 则第i+1个数为：
	 * 		1.如果ai*10<=n,则为ai*10,
	 * 		2.如果ai+1<n&&ai+1不进位(即ai个位不是9）。
	 * 		3.如果ai个位是9，则需要回退.
	 * 		回退可能不止一次，例如，199回退到19，个位再次是9，需要继续回退，一直回退到个位不在是9为止。
	 * 		算法实现就是(ai+1)%10!=9为止。
 */

public class Solution {
  public List<Integer> lexicalOrder(int n) {
    List<Integer> list=new ArrayList<>();
	  list.add(1);
		for(int i=1;i<n;i++){
			list.add(getNext(list.get(i-1),n));
	  }
	  return list;
  }
  
  //已知第i个数，求第i+1个数。
   public int getNext(int i,int n){
	  int result;
		if(i*10<=n){
			result=i*10;
		}
		else if(i+1<=n&&((i+1)/10==i/10)){
			result=i+1;
		}
		else{
			result=i/10;
			while((result+1)%10!=9)result=result/10;
			result++;
		}
		return result;
	}
}
