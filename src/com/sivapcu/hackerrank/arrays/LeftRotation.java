package com.sivapcu.hackerrank.arrays;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * A left rotation operation on an array of size shifts each of the array's
 * elements unit to the left. For example, if left rotations are performed on
 * array , then the array would become .
 * 
 * Given an array of integers and a number, , perform left rotations on the
 * array. Then print the updated array as a single line of space-separated
 * integers.
 * 
 * Input Format
 * 
 * The first line contains two space-separated integers denoting the respective
 * values of (the number of integers) and (the number of left rotations you must
 * perform). The second line contains space-separated integers describing the
 * respective elements of the array's initial state.
 * 
 * Constraints
 * 
 * Output Format
 * 
 * Print a single line of space-separated integers denoting the final state of
 * the array after performing left rotations.
 * 
 * Sample Input
 * 
 * 5 4 1 2 3 4 5 Sample Output
 * 
 * 5 1 2 3 4
 * 
 * @author sivasankar_r
 *
 */
public class LeftRotation {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        Stream.of(a).forEach(System.out::println);
        
	}
}
