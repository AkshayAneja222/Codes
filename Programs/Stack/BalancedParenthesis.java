package Programs.Stack;

import java.util.ArrayDeque;

public class BalancedParenthesis {
	
	public boolean isBalanced(String str)
	{
		ArrayDeque<Character> deque = new ArrayDeque<Character>();
		
		int n=str.length(), i=0;
		while(i<n)
		{
			char c = str.charAt(i);
			if(c == '{' || c == '(' || c == '[')
				deque.addLast(c);
			else
			{
				if(deque.isEmpty())return false;
				char top = deque.removeLast();
				switch(c)
				{
				case '}': 
					if(top!='{')
						return false;
					break;
				case ')':
					if(top!='(')
						return false;
					break;
				case ']':
					if(top!='[')
						return false;
					break;
				default : break;
				}
			}
			i++;
		}return deque.isEmpty();
	}
	
	public static void main(String[] args) {
		BalancedParenthesis bp = new BalancedParenthesis();
		boolean val = bp.isBalanced("()()((()))");
		System.out.println(val);
	}
}
