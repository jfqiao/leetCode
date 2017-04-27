package backtracking;
import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author fangqiao.jfq
 * ����������
 * ������������ n, k, ���� n >= k, 
 * ����1,..., n�� k �������������.
 * 
 * ����1�� �ݹ�ķ�ʽ
 * ����2����ջģ��ݹ顣
 */
public class Combination {
	private List<List<Integer>> result;
	
	public static void main(String[] args) {
		Combination c = new Combination();
		c.combine(4, 3);
		System.out.println(c.result);
	}
	
	public List<List<Integer>> combine(int n, int k) {
		result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		combineRecursive(n, k, list, 1);
		return result;
	}
	
	public void combineRecursive(int n, int k, List<Integer> list, int curPos) {

		if (list.size() == k) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		if (curPos <= n) {
	    //�е�ǰԪ�ص����
		list.add(curPos);
		combineRecursive(n, k, list, curPos + 1);
		//û�е�ǰԪ�ص����
		list.remove(new Integer(curPos));
		combineRecursive(n, k, list, curPos + 1);
		}
	}
}