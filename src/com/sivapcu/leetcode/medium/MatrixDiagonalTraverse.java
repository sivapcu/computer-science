package com.sivapcu.leetcode.medium;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of
 * the matrix in diagonal order as shown in the below image.
 * 
 * Input: [ 
 * 			[ 1, 2, 3 ], 
 * 			[ 4, 5, 6 ], 
 * 			[ 7, 8, 9 ] 
 *		  ] 
 * Output: [1,2,4,7,5,3,6,8,9]
 * 
 * @author siva
 *
 */
public class MatrixDiagonalTraverse {

	public static void main(String[] args) {
		int m = 3, n=3;
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		
		int i = 0, j = 0;
		int iDir = 0;
		int jDir = 1;
		int iLast = 0 , jLast = 0;
		do {
			System.out.println(matrix[i][j]);
		} while(m<=2 && n<=3);
	}
}
