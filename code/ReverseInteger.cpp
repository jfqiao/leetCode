/*
Problem:
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

*/
/*
判断两个数相乘是否overflow，可以用a*b/b,结果与a不同则overflow了，
判断两个数相加是否overflow，如果overflow则结果会变符号，(a+b)/a<0即可，注意a不可为0.
*/
class Solution {
public:
    int reverse(int x) {
        int result=0,tmp=0;
        while(x!=0){
            tmp=result*10/10;
            if(tmp!=result)return 0;
            tmp=result*10+x%10;
            if(tmp!=0&&result/tmp<0)return 0;
            result=tmp;
            x/=10;
        }
        return result;
    }
};
