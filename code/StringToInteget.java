/**
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

*/

/**
 *此题的经验：全局考虑的思维还不够，修改了多次才考虑到各种细节之处。
 * 可见细节之处处理不到位。
 * 
*/
//对于不符合转化的字符串，只取前面有效的部分。
//对于正负数要注意一下。另外就是如果超过整型的表示范围，就是overflow，
//根据测试用例可以看出是只取有效的部分
public class Solution {
    public int myAtoi(String str) {
     //注意int可以表示的正数与负数范围不一样
		if(str.length()==0)return 0;
		char [] num=str.trim().toCharArray();
		int result=0,flag=1;
		if(num[0]=='-'){
			flag=-1;
		}
		else if(num[0]=='+'){
		    
		}
		else if(Character.isDigit(num[0])){
			result=num[0]-48;
		}
		else{
			return 0;
		}
		for(int i=1;i<num.length;i++){
			if(Character.isDigit(num[i])){
				//根据题目给出的处理方法：向上溢出给出整型最大值
				//向下溢出给出整型最小值
				//int 可以表示的正数与负数范围有一点点区别。
				//负数可以到-2147483648，所以用正数表示负数的绝对值有点小问题。
				int tmp=result;
//				乘法溢出
				if(tmp*10/10!=tmp){
					if(flag==1)return Integer.MAX_VALUE;
					else return Integer.MIN_VALUE;
				}
//				加法溢出
				tmp=tmp*10+(num[i]-48)*flag;
				//向上溢出
				if(result>0&&tmp<0)return Integer.MAX_VALUE;
//				向下溢出
				if(result<0&&tmp>0)return Integer.MIN_VALUE;
				result=tmp;
			}
			else{
				break;
			}
		}
		return result;
	}
}
