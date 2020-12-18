package com.jitendrasaini.stringProblems;

/**
 * @author js674007
 * 
 *         Smallest window in a string containing all the characters of another
 *         string Given a string S and text T. Output the smallest window in the
 *         string S having all characters of the text T. Both the string S and
 *         text T contains lowercase english alphabets.
 * 
 *         Input: First line of the input contains an integer T, denoting the
 *         number of test cases. Then T test case follows. Each test contains 2
 *         lines having a string S and next line contains text T.
 * 
 *         Output: Output the smallest window of the string containing all the
 *         characters of the text. If such window doesn`t exist or this task can
 *         not be done then print -1.
 * 
 *         Constraints: 1 <= T <= 100 1 <= |N|, |X| <= 1000
 * 
 *         Example: Input: 2 timetopractice toc zoomlazapzo oza
 * 
 *         Output: toprac apzo
 * 
 *         Explanation: Testcase 1: "toprac" is the smallest substring in the
 *         given string S which contains every characters of T.
 *
 * 
 */
public class SmallestWindowString {

	public static String driver(String str, String text, int i, int j, int txtPointer, String minStr) {
		if (txtPointer == text.length()) {
			return str.substring(i, j);
		}
		if (j == str.length()) {
			return null;
		}
		String result = null;
			if (str.charAt(j) == text.charAt(0)) {
				result = driver(str, text, j, j+1, 0,minStr);
				if(result != null && (minStr== null || minStr.length()>result.length())) {
					minStr = result;
					//System.out.println("minStr 1:"+minStr);
				}
				//System.out.println("j:"+j+" 1:"+result);
			}
			if (str.charAt(j) == text.charAt(txtPointer)) {
				result= driver(str, text, i, j+1, txtPointer+1,minStr);
				if((result != null && (minStr== null || minStr.length()>result.length()))) {
					minStr = result;
					//System.out.println("minStr 2:"+minStr);
				}
				//System.out.println("j:"+j+" 2:"+result);
			} else {
				result= driver(str, text, i, j+1, txtPointer,minStr);
				if(result != null && (minStr== null || minStr.length()>result.length())) {
					minStr = result;
					//System.out.println("minStr 3:"+minStr);
				}
				//System.out.println("j:"+j+" 3:"+result);
			}
		
		return minStr;
	}

	public static String smallestWStr(String str, String text, int i, int j, int txtPointer) {



		String ans1=null;
		String ans2 = null;

		if(ans1!=null)
			return ans1;
		else
			return ans2;
	}

	public static void main(String[] args) {
		String str = "timetopractice";
		String out = driver(str, "toc", 0, 0, 0, null);
		System.out.println(out);
	}
}
