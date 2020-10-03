package Programs;
import java.util.*;
  import java.io.*;
  
  public class validString {
    public static void main(String args[]) throws IOException {
      
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     int t = Integer.parseInt(br.readLine());
     while(t-- !=0){
       Stack<Character> stack = new Stack<Character>();
       String str = br.readLine();
       int len = str.length();
       
       if(str.equals(" ") || str.trim().equals(""))
       {  
    	   System.out.println("Yes");
    	   continue;
       }
       else if(len%2!=0)
       {
    	   System.out.println("No");
    	   continue;
       }
       
       int left = 0;
       int right = 0;
       for(int i=0;i<len;i++) {
    	   char c =str.charAt(i);
    	   if(c=='(')
    		   left++;
    	   else if(c==')')
    		   right++;
       }
       if(left!=right) {
    	   System.out.println("No");
       }else {
    	   int changed=0;
    	   char[] arr = str.toCharArray();
    	   boolean flag = true;
    	  for(int i=0;i<len;i++) {
    		  char c =arr[i];
    		  if(c=='(') {
    			  stack.add(c);
    		  }else {
    			  if(stack.isEmpty()) {
    				  if(changed==1) {
    					  System.out.println("No");
    					  flag = false;
    					  break;
    				  }
    				  char cNext = arr[i+1];
    				  if(cNext == '(') {
    					 arr[i]='(';
    					 arr[i+1]=')';
    					 changed++;
    					 stack.add(arr[i]);
    				  }else {
    					  System.out.println("No");
    					  flag = false;
    					  break;
    				  }
    				  
    			  }else {
    				  stack.pop();
    			  }
    		  }
    	  }
    	  if(flag) {
    		  System.out.println("Yes");
    	  }
       }
     }
    }
  }