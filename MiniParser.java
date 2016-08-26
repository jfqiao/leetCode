package test;

/**
 * Problem describe:
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Note: You may assume that the string is well-formed:
 * 		String is non-empty.
 * 		String does not contain white spaces.
 * 		String contains only digits 0-9, [, - ,, ].
 * 
 * Example 1:
 * Given s = "324",
 * You should return a NestedInteger object which contains a single integer 324.
 * 
 * Example 2:
 * Given s = "[123,[456,[789]]]",
 * Return a NestedInteger object containing a nested list with 2 elements:
 * 		1. An integer containing value 123.
 * 		2. A nested list containing two elements:
 * 			i.  An integer containing value 456.
 * 			ii. A nested list with one element:
 * 				a. An integer containing value 789.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

 interface NestedInteger{

	public NestedInteger();

	public NestedInteger(int value);

	public boolean isInteger();
	
	public Integer getInteger();

	public void setInteger(int value) ;

	public void add(NestedInteger ni) ;

	public List<NestedInteger> getList();
 }
public class MiniParser {
	public NestedInteger deserialize(String ss) {
	      Stack<NestedInteger> stk = new Stack<>();
			int i = 0;
			int j = 1;
			NestedInteger current;
			int flag = 1;
			// stk.push(*current);
			char[] s = ss.toCharArray();
			for (int k = 0; k < s.length; k++) {
				switch (s[k]) {
				case '[':
					flag = 0;
					current = new NestedInteger();
					stk.push(current);
					break;
				case ']':
					if (s[k - 1] == ']') {
						NestedInteger first = stk.pop();
						NestedInteger sec = stk.peek();
						sec.add(first);
					} else if(s[k-1]!='[') {
					    i=i*j;
						stk.peek().add(new NestedInteger(i));
						i=0;
						j=1;
					}
					break;
				case ',':
					if (s[k - 1] == ']') {
						NestedInteger first = stk.pop();
						NestedInteger sec = stk.peek();
						sec.add(first);
					} else {
						i = i * j;
						stk.peek().add(new NestedInteger(i));
						j = 1;
						i = 0;
					}
					break;
				case '1':
					i = i * 10 + 1;
					break;
				case '2':
					i = i * 10 + 2;
					break;
				case '3':
					i = i * 10 + 3;
					break;
				case '4':
					i = i * 10 + 4;
					break;
				case '5':
					i = i * 10 + 5;
					break;
				case '6':
					i = i * 10 + 6;
					break;
				case '7':
					i = i * 10 + 7;
					break;
				case '8':
					i = i * 10 + 8;
					break;
				case '9':
					i = i * 10 + 9;
					break;
				case '0':
					i = i * 10;
					break;
				case '-':
					j = -1;
					break;
				default:
					break;

				}
			}
			NestedInteger result;
			if (flag == 1) {
				result = new NestedInteger(i * j);
				return result;
			}
			result = stk.pop();
			while (!stk.empty()) {
				stk.peek().add(result);
				result = stk.pop();
			}
			return result;
	    }
}
