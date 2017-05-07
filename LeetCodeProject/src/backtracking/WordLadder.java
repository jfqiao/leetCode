package backtracking;

import java.util.List;
import java.util.ArrayList;

/**
 * Problem description: Given two words (beginWord and endWord), and a
 * dictionary's word list, find the length of shortest transformation sequence
 * from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time. Each transformed word must exist in
 * the word list. Note that beginWord is not a transformed word. For example,
 * 
 * Given:
 * beginWord = "hit"
 * endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log","cog"] As one shortest transformation is
 *  "hit"-> "hot" -> "dot" -> "dog" -> "cog", 
 *  return its length 5.
 * 
 * Note: 
 *     Return 0 if there is no such transformation sequence. 
 *     All words have the same length. 
 *     All words contain only lower case alphabetic characters. 
 *     You may assume no duplicates in the word list. 
 *     You may assume beginWord and endWord are non-empty and are not the same.
 *
 * 
 * @author jfq
 *
 */
public class WordLadder {
	public static void main(String[] args) {
		
	}
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		
		return 0;
	}
	
	private List<String> findDifferInOneChar(String ori, List<String> wordList) {
		List<String> dis = new ArrayList<String>();
		for (int i = 0; i < wordList.size(); i++) {
			if (isDifferInOneChar(ori, wordList.get(i))) {
				dis.add(wordList.get(i));
			}
		}
		return dis;
	}
	
	//note: you may assume that the string ori and cmp are the same length.
	private boolean isDifferInOneChar(String ori, String cmp) {
		int count = 0;
		for (int i = 0; i < ori.length(); i++) {
			if (ori.charAt(i) != cmp.charAt(i)) {
				count++;
			}
		}
		if (count == 1)
			return true;
		else
			return false;
	}
	
}
