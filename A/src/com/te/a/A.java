package com.te.a;

public class A {
	public static boolean isStringOnlyAlphabet(String str)
    {
 
        return ((str != null) && (!str.equals(""))
                && (str.matches("^[a-zA-Z\s]*$")));
    }
 
    // Method 2
    // Main driver method
    public static void main(String[] args)
    {
 
        // Calling out methods over string
        // covering all sceneriaos
 
        // Use case 1
        System.out.println("Test Case 1:");
        // Input string
        String str1 = "Geeksfo @rGeeks";
        System.out.println("Input: " + str1);
 
        System.out.println("Output: "
                           + isStringOnlyAlphabet(str1));
 
        // Use case 2
        // Checking for String with numeric characters
        System.out.println("\nTest Case 2:");
        // Input string
        String str2 = "Geeks4Geeks";
        System.out.println("Input: " + str2);
        System.out.println("Output: "
                           + isStringOnlyAlphabet(str2));
 
        // Use Case 3
        // Checking for null String
        System.out.println("\nTest Case 3:");
        // Input string
        String str3 = null;
        System.out.println("Input: " + str3);
        System.out.println("Output: "
                           + isStringOnlyAlphabet(str3));
 
        // Use Case 4
        // Checking for empty String
        System.out.println("\nTest Case 4:");
        // Input string
        String str4 = "";
        System.out.println("Input: " + str4);
        System.out.println("Output: "
                           + isStringOnlyAlphabet(str4));
    }
}
