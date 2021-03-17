package com.qlik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qlik.service.PalindromeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/palindromes/v1")
@Api(tags = "Palindrome Management RESTful Services", value = "Palindrome Service")
public class PalindromeController {

	@Autowired
	private PalindromeService palindromeService;
	
	@ApiOperation(value = "Get the cart", response = Boolean.class)
	@GetMapping("/palindrome_flag/{paragraph}")
	public boolean isPalindrome(@PathVariable String paragraph)
	{
		return palindromeService.isPalindrome(paragraph);
		
		//return palindromeService.isPalindromeUsingWhileloop(paragraph);
	}
	
	@ApiOperation(value = "Get the cart", response = Integer.class)
	@GetMapping("/palindrome_count/{bigParagraph}")
	public int getAllPalindromeCount(@PathVariable String bigParagraph)
	{
		return palindromeService.getAllPalindromeCount(bigParagraph);
	}
}
