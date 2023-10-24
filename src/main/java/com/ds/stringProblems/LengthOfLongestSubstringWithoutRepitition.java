package com.ds.stringProblems;

import java.util.*;

public class LengthOfLongestSubstringWithoutRepitition {

    private static final int NO_OF_CHARS = 256;

    public static void main(String[] args) {
      System.out.println(lengthOfLongestSubstring("abcabcbb"));//abc-3
      System.out.println(lengthOfLongestSubstring("bbbbb"));//b-1
       System.out.println(lengthOfLongestSubstring("pwwkew"));//wke-3
       System.out.println(lengthOfLongestSubstring("au"));//au-2
      System.out.println(lengthOfLongestSubstring("aab"));//ab-2
        System.out.println(lengthOfLongestSubstring("dvdf"));//vdf-3
        System.out.println(lengthOfLongestSubstring("asjrgapa"));//6

        ///System.out.println(updateCurrentSubstring(new LinkedList<>(Arrays.asList('p','w')),'w'));
    }


    private static int lengthOfLongestSubstringLinearTime(String str) {

        if(null == str || str.isEmpty()) {
            return 0;
        } else if(str.length()==1) {
            return 1;
        }

        int n = str.length();
        int cur_len = 1; // length of current substring
        int max_len = 1; // result
        int prev_index; // previous index
        int i;
        int[] visited = new int[NO_OF_CHARS];
        LinkedList<Character> currentSubstring = new LinkedList<>();

		/* Initialize the visited array as -1, -1 is
		used to indicate that character has not been
		visited yet. */
        for (i = 0; i < NO_OF_CHARS; i++) {
            visited[i] = -1;
        }

		/* Mark first character as visited by storing the
			index of first character in visited array. */
        visited[str.charAt(0)] = 0;
        currentSubstring.add(str.charAt(0));
		/* Start from the second character. First character is
		already processed (cur_len and max_len are initialized
		as 1, and visited[str[0]] is set */
        for (i = 1; i < n; i++) {
            prev_index = visited[str.charAt(i)];

			/* If the current character is not present in
		the already processed substring or it is not
			part of the current NRCS, then do cur_len++ */
            if (prev_index == -1 || !currentSubstring.contains(str.charAt(i))) {
                cur_len++;
                currentSubstring.add(str.charAt(i));
            }

			/* If the current character is present in currently
			considered NRCS, then update NRCS to start from
			the next character of the previous instance. */
            else {
				/* Also, when we are changing the NRCS, we
				should also check whether length of the
				previous NRCS was greater than max_len or
				not.*/
                if (cur_len > max_len)
                    max_len = cur_len;

                cur_len = i - prev_index;
                currentSubstring= updateCurrentSubstring(currentSubstring,str.charAt(i));
            }

            // update the index of current character
            visited[str.charAt(i)] = i;
        }

        // Compare the length of last NRCS with max_len and
        // update max_len if needed
        if (cur_len > max_len)
            max_len = cur_len;
        System.out.println(currentSubstring);
        return max_len;
    }

    private static  LinkedList<Character> updateCurrentSubstring(LinkedList<Character> currentSubstring, Character ch) {
        int length = currentSubstring.size();
        for(int i=length-1;i>=0;i--) {
            if(ch == currentSubstring.get(i)) {
              return  i==length-1 ? new LinkedList<>(Arrays.asList(ch)) : new LinkedList<>(currentSubstring.subList(i,length));
            }
        }
        return new LinkedList<>();
    }

    private static int lengthOfLongestSubstring(String s) {

         if(null == s || s.isEmpty()) {
             return 0;
         } else if(s.length()==1) {
             return 1;
         }

         int longestSubstringLength = 0;
         int startIndex = 0;
         Set<Character> currentSubstring = new LinkedHashSet<>();
             for (char x : s.toCharArray()) {
                 if (currentSubstring.contains(x)) {
                     while(s.charAt(startIndex) != x) {
                         currentSubstring.remove(s.charAt(startIndex));
                         startIndex++;
                     }
                     currentSubstring.remove(s.charAt(startIndex));
                     startIndex++;
                 }
                 currentSubstring.add(x);
                 longestSubstringLength = Math.max(longestSubstringLength,currentSubstring.size());


             }
             return longestSubstringLength;
    }
}
