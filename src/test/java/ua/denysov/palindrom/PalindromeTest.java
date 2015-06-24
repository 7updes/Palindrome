package ua.denysov.palindrom;

import org.junit.Test;

import static org.junit.Assert.*;


public class PalindromeTest {

    @Test
    public void testPalindromeFinder(){
        assertEquals(Palindrome.palindromeFinder(76512), 76567);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPalindromeFinder1(){
        Palindrome.palindromeFinder(-1);
    }

}