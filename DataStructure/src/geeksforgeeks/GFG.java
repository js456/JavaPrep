package geeksforgeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.jws.HandlerChain;

/**
 * @author Jitendra
 *
 */
class GFG {

	static class Pair {
		int m;
		int n;

		@Override
		public boolean equals(Object obj) {
			return ((this.m == ((Pair)obj).m)&&(this.n == ((Pair)obj).n));
		}

		@Override
		public int hashCode() {
			return 31+this.m*17+this.n*37;
		}
	}

	public static int maxArea(int arr[]) {

		for (int index = 0; index < arr.length; index++) {
			if (index < 0 || index >= arr.length)
				return 0;
			int maxArea = 0;
			int i = index;
			while (i >= 0 && arr[i] >= arr[index]) {
				maxArea += arr[i--];
			}
			int j = index;
			while (j < arr.length && arr[j] >= arr[index]) {
				maxArea += arr[j++];
			}
		}
		return 0;

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		// continue loop for all test cases
		while (testCase > 0) {
			int noOfWords = sc.nextInt();
			ArrayList<String>wordsArr = new ArrayList<String>();
			// Take no of words input and store in an array
			for (int i = 0; i < noOfWords; i++) {
				wordsArr.add(sc.next());
			}
			int rowCount = sc.nextInt();
			int columnCount = sc.nextInt();
			char[][] matrix = new char[rowCount][columnCount];
			// Take characters input and create a matrix
			for (int i = 0; i < rowCount; i++) {
				for (int j = 0; j < columnCount; j++) {
					matrix[i][j] = sc.next().charAt(0);
				}
			}
			// Iterate for all the words present in the test case
		    Collections.sort(wordsArr);
			ArrayList<String>wordList = new ArrayList<String>();
			for (String tempWord : wordsArr) {
			    if(wordList.contains(tempWord)) 
			        continue;
				if (checkWordPresent(matrix, tempWord)) {
					System.out.print(tempWord);
					wordList.add(tempWord);
					System.out.print(" ");
				}
			}
			System.out.println();
			testCase--;

		}

	}

	/**
	 * @param matrix
	 * @param word
	 * @return True if word can be formed using matrix
	 */
	public static boolean checkWordPresent(char[][] matrix, String word) {
		char[] charArr = word.toCharArray();
		ArrayList<Pair>visitedList = new ArrayList<Pair>();
		ArrayList<Pair> pairList = getIndexValue(charArr[0], matrix,visitedList);
		if (pairList.size() <= 0)
			return false;
		if(charArr.length==1)
		    return true;
		for (Pair pair : pairList) {
			for (int i = 1; i < charArr.length; i++) {
				pair = checkAllPairsIfCharPresent(pair, matrix, charArr[i],visitedList);
				if (i == charArr.length - 1 && pair != null) {
					return true;
				}

			}
		}
		return false;
	}

	public static Pair checkAllPairsIfCharPresent(Pair pair, char[][] matrix, char ch,ArrayList<Pair>visitedList) {
		if (pair == null)
			return null;
		int m = pair.m;
		int n = pair.n;
		// Iterate for all the adjacent characters by ch
		// //[m-1,n-1], [m-1,n], [m-1, n+1], [m,n-1], [m,n+1], [m+1 n-1], [m+1,n] [m+1,
		// n+1]
		for (int i = m - 1; i < m + 2; i++) {
			for (int j = n - 1; j < n + 2; j++) {
				if (i == m && j == n) {
					continue;
				}
				// Check if character present in any of the adjacent character if present then
				// return pair of row and column
				if (isValidIndex(matrix.length, matrix[0].length, i, j) && matrix[i][j] == ch) {
					Pair tempPair = new Pair();
					tempPair.m = i;
					tempPair.n = j;
					if(!visitedList.contains(tempPair)){
					    visitedList.add(tempPair);
					    return tempPair;
					}
				}
			}
		}
		return null;

	}

	/**
	 * @param c
	 * @param matrix
	 * @return Returns the list of all the pairs where character is present Pair
	 *         contains value of row and column
	 */
	public static ArrayList<Pair> getIndexValue(char c, char[][] matrix,ArrayList<Pair>visitedList) {
		ArrayList<Pair> pairList = new ArrayList<Pair>();
		;
		Pair pair = null;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == c) {

					pair = new Pair();
					pair.m = i;
					pair.n = j;
					pairList.add(pair);
				}
			}
		}
		return pairList;

	}

	/**
	 * @param rowCount
	 * @param columnCount
	 * @param m
	 * @param n
	 * @return True if index is valid False if index is invalid
	 */
	public static boolean isValidIndex(int rowCount, int columnCount, int m, int n) {
		if ((m >= 0 && m < rowCount) && (n >= 0 && n < columnCount)) {
			return true;
		}
		return false;
	}
}