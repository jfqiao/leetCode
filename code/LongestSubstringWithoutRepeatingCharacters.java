package code;
/**
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/


//这是�?种利用空间的解决办法
//�?要想�?个更优的�?
public class Solution {
    private int pos;
	private int num;
	public Solution(){
		pos=-1;
		num=0;
	}
    public int lengthOfLongestSubstring(String s) {
        char [] ss=s.toCharArray();
		int result=0;
        
		Solution [] list=new Solution[128];
		for(int i=0;i<list.length;i++){
			list[i]=new Solution();
		}
		int p=0,q=0;
		while(q<s.length()){
			//当前字符在数组中的下�?
			int index=ss[q];
			//如果当前字符未出现过，记录当前字 符已经出现，并记录位置�?�q下移�?位�??
			if(list[index].num==0){
				list[index].pos=q;
				list[index].num=1;
			}
			//如果当前字符出现过，首先比较长度并记�?
			else{
				if(result<q-p)result=q-p;
//				重置重开始位置p到重复字符位置所有字符的属�?��??
				for(int i=p;i<list[index].pos;i++){
					list[ss[i]].num=0;
					list[ss[i]].pos=-1;
				}
//				p挪到重复字符下一个位�?
				p=list[index].pos+1;
//				修改重复字符的位置，因为前一个位置是重复字符�?
				list[index].pos=q;
			}
//			�?后面的字符向后移动一�?
			q++;
		}
		if(result<q-p)result=q-p;
		return result;
    }
}
