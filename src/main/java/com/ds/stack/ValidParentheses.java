package com.ds.stack;

import java.util.*;

public class ValidParentheses {

    static List<Character> opening = Arrays.asList('(','[','{');
    static List<Character> closing = Arrays.asList(')',']','}');
    static List<Character> pair1 = Arrays.asList('(',')');
    static List<Character> pair2 = Arrays.asList('[',']');
    static List<Character> pair3 = Arrays.asList('{','}');



    public static void main(String[] args) {
        System.out.println(isValid(""));
        System.out.println(isValid("(())"));
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }

    private static boolean isValid(String s) {

        if(s.isEmpty()) {
            return true;
        } else if(s.length()==1) {
            return false;
        } else if(s.length()==2 && closing.contains(s.charAt(0))) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] characters = s.toCharArray();
        for (int i=0;i<characters.length;i++){

            if(opening.contains(s.charAt(i))) {
               stack.push(characters[i]);
            }

            if(closing.contains(s.charAt(i))) {
                if(stack.empty()) {
                    return false;
                }
                Character ch = stack.pop();
                List<Character> list = getList(s.charAt(i)).get();
               if(list.isEmpty() || list.get(0)!=ch ) {
                 return false;
               }
            }
        }


        return stack.empty();
    }

    private static Optional<List<Character>> getList(Character ch) {
        if(pair1.contains(ch)) {
            return Optional.of(pair1);
        } else if(pair2.contains(ch)) {
            return Optional.of(pair2);
        } else if(pair3.contains(ch)) {
            return Optional.of(pair3);
        }
        return Optional.empty();
    }
}
