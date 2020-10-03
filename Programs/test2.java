import java.util.*;
  import java.io.*;

  public class test2 {

  
  public static boolean checkPattern(String str, String ptr)
  {
      int i=0, j=0;
      
      while(i<ptr.length())
      {
        if(ptr.charAt(i)==str.charAt(j))
        {
        	//System.out.println("equal characters  "+ptr.charAt(i));
          i++;
          j++;
        }
        else if(ptr.charAt(i)=='*')
        {
          if(i==ptr.length()-1){
            return true;
          }
          
          while(str.charAt(j)!=ptr.charAt(i+1))
          {
            //System.out.println("char at "+j+" is not equal to char at in ptr "+(i+1));
            if(j==str.length()-1 && i!=ptr.length()-1)
              return false;  
            j++;
          }
          j++;
          i=i+2;
        }
        else if(ptr.charAt(i)=='?')
        {
          if(i+1<ptr.length() && j+1<str.length() && str.charAt(j+1)!=ptr.charAt(i+1))
          return false;
          
          i++;
          j++;
        }
        else
        {
          return false;
        }
      }
      //System.out.println(j);
      if(i>=ptr.length() && j>=str.length())
      return true;
      
      return false;
  }
   
   
    public static void main(String args[]) throws IOException {
      
      Scanner sc = new Scanner(System.in);
      String str = sc.nextLine();
      String ptr = sc.nextLine();
      
      System.out.println(checkPattern(str, ptr));
    }
  }