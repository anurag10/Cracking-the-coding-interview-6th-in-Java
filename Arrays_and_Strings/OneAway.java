/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class OneAway
{
	
	static boolean isOneEditAway(String ref, String s)
	{
		int lenRef = ref.length();
		int lenS = s.length();
		
		int mismatchCnt = 0;
		if (lenS == lenRef)
		{
			// one replace
			for(int i = 0; i < lenS; i++)
			{
				if (s.charAt(i) != ref.charAt(i))
				{
					mismatchCnt++;
				}
				
				if (mismatchCnt > 1)
					return false;
			}
			
			return true;
		}
		else if (lenS == lenRef-1)
		{
			// one add
			for(int i = 0, j = 0; i < lenS && j < lenRef; j++)
			{
				if (s.charAt(i) != ref.charAt(j))
				{
					mismatchCnt++;
				}
				else
				{
					i++;
				}
				
				if (mismatchCnt > 1)
					return false;
			}
			
			return true;
		}
		else if (lenS == lenRef+1)
		{
			// one delete
			for(int i = 0, j = 0; i < lenS && j < lenRef; i++)
			{
				if (s.charAt(i) != ref.charAt(j))
				{
					mismatchCnt++;
				}
				else
				{
					j++;
				}
				
				if (mismatchCnt > 1)
					return false;
			}
			
			return true;
		}
		
		return false;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(isOneEditAway("ababa", "abba") ? "True" : "False");
		System.out.println(isOneEditAway("ababa", "abbba") ? "True" : "False");
		System.out.println(isOneEditAway("abba", "ababa") ? "True" : "False");
		System.out.println(isOneEditAway("aaaaaa", "aaabba") ? "True" : "False");
	}
}