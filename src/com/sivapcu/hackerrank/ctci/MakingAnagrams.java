package com.sivapcu.hackerrank.ctci;

public class MakingAnagrams {
    public static int numberNeeded(String first, String second) {
      int deleteCount = first.length() + second.length();
      for(int i = 0; i<first.length(); i++) {
    	  char c = first.charAt(i);
    	  for(int j=0; j< second.length(); j++) {
    		  char d = second.charAt(j);
    		  if(c == d) {
    			  
    		  }
    	  }
      }
      return deleteCount;
    }
  
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String a = in.next();
//        String b = in.next();
//        in.close();
    	String a = "cde";
    	String b = "abc";
    	
        System.out.println(numberNeeded(a, b));
        
    }
}
