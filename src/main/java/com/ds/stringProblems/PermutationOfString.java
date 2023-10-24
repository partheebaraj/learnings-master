package com.ds.stringProblems;

import java.util.HashSet;
import java.util.Set;

public class PermutationOfString {

    public static void main(String[] args) {

        permutationOfString("abc").forEach(System.out::println);
    }

    static Set<String> permutationOfString(String str){
        Set<String>perm=new HashSet<>();
        if(str==null){
            return null;
        }
        if(str.length()==0){
            perm.add("");
            return perm;
        }
        char initial=str.charAt(0);
        String rem=str.substring(1);
        Set<String> words=permutationOfString(rem);
        for(String strNew:words){
            for(int i=0;i<=strNew.length();i++){
                perm.add(charInsert(strNew,initial,i));
            }
        }
        return perm;
    }
    static String charInsert(String str,char c,int j){
        String begin=str.substring(0,j);
        String end=str.substring(j);
        return begin+c+end;
    }
}
