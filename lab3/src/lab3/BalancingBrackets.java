package lab3;

import java.util.Stack;

public class BalancingBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String input= "([[{}]])";
		 if(checkBalancingString(input))
			 System.out.println("The entered String has Balanced Brackets");
		 
		 else
			 System.out.println("The entered Strings do not contain Balanced Brackets");
		 
	}
	
	public static boolean checkBalancingString(String expression)
	{
		Stack<Character> CharStack= new Stack<Character>();
		for(int i=0;i<expression.length();i++)
		{
			char character = expression.charAt(i);
			if(character=='{' ||character=='[' ||character=='(')
			{
				CharStack.push(character);
				continue;
			}
			if(CharStack.isEmpty())
			{
				return false;
			}
			char ch = CharStack.pop();;
			 switch(character)
			 {
			 case ')':
				 if(ch !='(')
					 return false;
				 break;

			 case '}':
				 if(ch !='{')
					 return false;
				 break;

			 case ']':
				 if(ch !='[')
					 return false;
				 break;
			 }
		}
		return CharStack.isEmpty();
	}

}
