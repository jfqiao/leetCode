package stack;

/**
 * problem description:
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * 
 * @author jfqiao
 *
 */

// direct idea: traverse the array to find the minimum number 
// idea2: space ~ time trade off, use array to save minimum number for every top
// idea3: 
public class MinStack {
	
	int[] nums;
	int top;
	int[] mins;

	public MinStack() {
		this.nums = new int[10];
		this.mins = new int[10];
		this.top = -1;
	}

	public void push(int x) {
		this.top++;
		if (this.top == this.nums.length) {
			int[] srcArr = this.nums;
			this.nums = new int[this.nums.length * 2];
			System.arraycopy(srcArr, 0, this.nums, 0, srcArr.length);
			srcArr = this.mins;
			this.mins = new int[this.nums.length];
			System.arraycopy(srcArr, 0, this.mins, 0, srcArr.length);
		}
		this.nums[this.top] = x;
		if (this.top > 0)
			this.mins[this.top] = Math.min(this.mins[this.top - 1], x);
		else
			this.mins[this.top] = x;
	}

	public void pop() {
		if (this.top >= 0)
			this.top--;
	}

	public int top() {
		if (this.top < 0)
			return -1;
		return this.nums[this.top];
	}

	public int getMin() {
		if (this.top < 0)
			return -1;
		return this.mins[this.top];
	}
	
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());   //--> Returns -3.
		minStack.pop();
		System.out.println(minStack.top());      //--> Returns 0.
		System.out.println(minStack.getMin());   // return -2
	}
}
