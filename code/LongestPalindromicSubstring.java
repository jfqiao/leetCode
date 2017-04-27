package code;
/**
Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
查找�?长的回文子字符串�?
*/
//找出�?个字符串中最长的回文字符�?
/**
 * 首先是查找回文字符串，根据规则，可以知道回文字符出现的地方至少有形如aba或aa的字�?
 * 因此�?要先找到�?个字母，他左右的字符是相同的则继续寻找，否则下一个字符�??
 */
public class Solution {
    public String longestPalindrome(String s) {
        char [] sc=s.toCharArray();
		if(s.length()==1)return s;
		//left 记录回文字符串左侧位�?
		//right 记录回文字符串右侧位�?
		//point 指向当前访问字符的位�?
		//start 返回结果�?始的位置
		//end  返回结果结束的位�?
		int left=0,right=0,point=0,len=s.length(),start=0,end=0;
		while(point<len){
			if(point-1>=0&&sc[point-1]==sc[point]){
				left=point-1;
				right=point;
				while(left>=0&&right<len){
					if(sc[left]==sc[right]){
						left--;
						right++;
					}
					else break;
				}
				//恢复到有效位�?
				left++;right--;
				if(right-left>end-start){
					end=right;
					start=left;
				}
			}
			if(point-1>=0&&point+1<len&&sc[point-1]==sc[point+1]){
				left=point-1;
				right=point+1;
				while(left>=0&&right<len){
					if(sc[left]==sc[right]){
						left--;
						right++;
					}
					else break;
				}
				//恢复到有效位�?
				left++;right--;
				if(right-left>end-start){
					end=right;
					start=left;
				}
			}
			
			point++;
		}
		return s.substring(start, end+1);
    }
}
