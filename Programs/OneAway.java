
public class OneAway {
	
	public static void main(String[] args) {
		 String one = "abcdefa";
		 String two = "abde";
		 String three = "abddgfa";
		  
		 System.out.println(isOneAway(one,two));
		 System.out.println(isOneAway(one,three));
	}
	
	public static boolean isOneAway(String first,String second) {
		if (Math.abs(first.length()-second.length())>1)
			return false;
		if (first.length()==second.length()) {
			return isOneReplaceAway(first,second);
		}else if(first.length()+1==second.length()){
			return isOneAddOrSubAway(first,second);
		}else {
			return isOneAddOrSubAway(second,first);
		}
	}

	private static boolean isOneAddOrSubAway(String first, String second) {
		int i=0,j=0;
		while(i<first.length() && j<second.length()) {
			if(first.charAt(i)!=second.charAt(j)) {
				j++;
			}else {
				i++;
				j++;
			}
		}
		return (i==first.length());
	}

	private static boolean isOneReplaceAway(String first, String second) {
		int flag=0;
		for (int i=0;i<first.length();i++) {
			if(first.charAt(i)!=second.charAt(i)) {
				if (flag==1)
					return false;
				flag++;
			}
		}
		return true;
	}
	
}
