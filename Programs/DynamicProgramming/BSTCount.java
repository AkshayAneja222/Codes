package Programs.DynamicProgramming;

/*
 * Count number of BST, when the nodes are given
 */

import java.util.*;
import java.io.*;
  
  public class BSTCount {
    
    public static long getCatalan(int num)
    {
      long[] catalan = new long[num+1];
      
      catalan[0]=1;
      catalan[1]=1;
      
      for(int i=2;i<=num;i++)
      {
        for(int j=0;j<i;j++)
        {
          catalan[i]+=catalan[j]*catalan[i-j-1];
        }
      }
      return catalan[num];
    }
    
    public static void main(String args[]) throws IOException {
      
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      
      while(t-->0)
      {
        int num = sc.nextInt();
        System.out.println(getCatalan(num));
      }
      sc.close();
    }
  }