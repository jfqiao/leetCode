package array;

import java.util.List;
import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * @author jfqiao
 *
 */
public class PascalTriangle {
	public static void main(String[] args) {	
		PascalTriangle pt = new PascalTriangle();
		List<List<Integer>> list = pt.generate(5);
		System.out.println(list.toString());
	}
	
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> ilist = null;
        for (int i = 0; i < numRows; i++) {
        	ilist = new ArrayList<Integer>();
        	list.add(ilist);
        	if (list.size() == 1) {
        		list.get(0).add(1);
        		continue;
        	}
        	for (int j = 0; j < list.get(i - 1).size(); j++) {
        		if (j == 0)
        			list.get(i).add(1);
        		else
        			list.get(i).add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
        	}
        	list.get(i).add(1);
        }
        return list;
    }
}
