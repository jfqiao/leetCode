/*
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.

*/

//判断一个数是否为回文数。
class Solution {
public:
    bool isPalindrome(int i) {
       if(i<0)return false;
		int tmp = i,front=1,rear=10;
		while (tmp>=10) {
			tmp = tmp / 10;
			front*=10;
		}
		while(front>=rear){
			if((i/front)%10!=i%rear/(rear/10))return false;
			front/=10;
			rear*=10;
		}
		return true;
    }
};
