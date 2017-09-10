package array;

import java.util.List;
import java.util.ArrayList;
/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author jfqiao
 *
 */
public class PascalTriangleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalTriangleII ps = new PascalTriangleII();
		System.out.println(ps.getRow(0));
	}
	
	public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int pre, tmp;
        for(int i = 0; i < rowIndex; i++) {
            int size = list.size();
            pre = 1;
            for (int j = 1; j < size; j++) {
                tmp = list.get(j);
                list.set(j, pre + list.get(j));
                pre = tmp;
            }
            list.add(1);
        }
        return list;
    }

}
