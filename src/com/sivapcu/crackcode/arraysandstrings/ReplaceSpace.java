package com.sivapcu.crackcode.arraysandstrings;

/**
 * Write a method to replace all spaces in a string with ‘%20’.
 * 
 * @author sivasankar_r
 *
 */
public class ReplaceSpace {
	public static void main(String[] args) {
		System.out.println(replaceSpace("S I V A"));
//		System.out.println(replaceCharWithString("ABCD", 'B', "ZZZZZZZZZZZ"));
	}
	
	public static String replaceSpace(String str) {
		int spaceCount = 0; 
		char[] input = str.toCharArray();
		for(char c : input) {
			if(c == ' ') {
				spaceCount++;
			}
		}
		int newLength = str.length() + spaceCount*2;
		char[] output = new char[newLength];
		for(int i = 0, j=0; i < str.length(); i++) {
			if(str.charAt(i) != ' ') {
				output[j++] = input[i];
			} else {
				output[j++] = '%';
				output[j++] = '2';
				output[j++] = '0';
			}
		}
		return String.valueOf(output);
	}
	
	public static String replaceCharWithString(String input, char target, String replacement) {
		char[] inputArray = input.toCharArray();
		int targetOccurence = 0;
		for(char c : inputArray) {
			if(c == target) {
				targetOccurence++;
			}
		}
		int targetStringLength = input.length() + (targetOccurence * (replacement.length()-1));
		char[] outputArray = new char[targetStringLength];
		for(int inputIndex = 0, outputIndex = 0; inputIndex < inputArray.length; inputIndex++) {
			if(inputArray[inputIndex] != target) {
				outputArray[outputIndex++] = inputArray[inputIndex];
			} else {
				for(int position = 0; position < replacement.length(); position++) {
					outputArray[outputIndex++] = replacement.charAt(position);
				}
			}
		}
		return String.valueOf(outputArray);
	}
}
