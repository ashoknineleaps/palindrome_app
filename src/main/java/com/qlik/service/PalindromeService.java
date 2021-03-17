package com.qlik.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.qlik.constant.Constant;
import com.qlik.exception.ParagraphException;
import com.qlik.model.Palindrome;

@Service
public class PalindromeService {

	public static Map<Palindrome, String> map = new HashMap<>();

	static {
		Palindrome palindromeKey1 = new Palindrome("aba");
		Palindrome palindromeKey2 = new Palindrome("kayak");
		Palindrome palindromeKey3 = new Palindrome("level");
		Palindrome palindromeKey4 = new Palindrome("ashok");
		Palindrome palindromeKey5 = new Palindrome("abcba");
		

		map.put(palindromeKey1, "aba");
		map.put(palindromeKey2, "kayak");
		map.put(palindromeKey3, "level");
		map.put(palindromeKey4, "ashok");
		map.put(palindromeKey5, "abcba");
	}
	
	
	//Using Java 8 Stream API
	public boolean isPalindrome(String paragraph) {

		if(paragraph.isBlank())
		{
			throw new ParagraphException("Invalid input paragraph");
		}
		
		Palindrome palindrome = new Palindrome(paragraph);
		
		if(!map.containsKey(palindrome))
		{
			map.put(palindrome, paragraph);
		}

		String copyStr = map.get(palindrome).replaceAll(Constant.REGEX_SPACE, Constant.EMPTY_STRING).toLowerCase();
		int startInclusive = 0;
		int endExclusive = copyStr.length() / 2;
		
		return IntStream.range(startInclusive, endExclusive)
				.noneMatch(message -> copyStr.charAt(message) != copyStr.charAt(copyStr.length() - message - 1));
		


	}
	
	//Using using while loop
	public boolean isPalindromeUsingWhileloop(String paragraph) {
		
		if(paragraph.isBlank())
		{
			throw new ParagraphException("Invalid input paragraph");
		}
		
		Palindrome palindrome = new Palindrome(paragraph);
		
		if(!map.containsKey(palindrome))
		{
			map.put(palindrome, paragraph);
		}

		String copyStr = map.get(palindrome).replaceAll(Constant.REGEX_SPACE, Constant.EMPTY_STRING).toLowerCase();

		int start = 0;
		int end = copyStr.length()-1;
		
		while(start < end)
		{
			if(copyStr.charAt(start) != copyStr.charAt(end))
			{
				return false;
			}
			
			start++;
			end--;
		}
		
		return true;
	}
	
	public int getAllPalindromeCount(String bigParagraph)
	{
		List<String> palindromes = new ArrayList<>();
		String[] words = bigParagraph.split(" ");
		
		for(int i=0; i<words.length; i++)
		{
			String word = words[i];
			
			boolean result = isPalindrome(word);
			
			if(result)
			{
				palindromes.add(word);
			}
		}
		
		return palindromes.size();
	}

}
