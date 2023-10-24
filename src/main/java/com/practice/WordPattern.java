package com.practice;

import java.util.HashMap;

/**https://leetcode.com/problems/word-pattern/
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 *
 *
 *
 * Example 1:
 *
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= pattern.length <= 300
 * pattern contains only lower-case English letters.
 * 1 <= s.length <= 3000
 * s contains only lowercase English letters and spaces ' '.
 * s does not contain any leading or trailing spaces.
 * All the words in s are separated by a single space.
 */
public class WordPattern {
    public static void main(String[] args) {


        String pattern="abba";
        String s =       "dog cat cat dog";
        System.out.println("Value is " + wordPattern(pattern,s));
    }

    static boolean wordPattern(String pattern, String s) {
        HashMap<String,String> hashMap1 = new HashMap<>();
        HashMap<String,String> hashMap2 = new HashMap<>();
        String[] str = s.split(" ");
        for (int i = 0; i < pattern.length(); i++) {
           if(pattern.length()!=str.length){
               return false;
           }
            String a = String.valueOf(pattern.charAt(i));
            if (hashMap1.containsKey(a)){
                if (!(hashMap1.get(a).equalsIgnoreCase( str[i]))){
                    return false;
                }
            } else {
                hashMap1.put(String.valueOf(pattern.charAt(i)), str[i]);
            } if(hashMap2.containsKey(str[i])){
                if(!hashMap2.get(str[i]).equalsIgnoreCase(a)){
                    return false;
                }

            } else
                hashMap2.put(str[i],a);
        }
        return true;
    }
}
