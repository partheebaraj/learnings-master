package com.ds.Trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private final TrieNode root;

    public  Trie (){
        root = new TrieNode();
    }


    public void insert(String word) {
        TrieNode current = root;

        for(int i=0;i<word.length();i++) {
            Character ch = word.charAt(i);
            TrieNode node = current.map.get(ch);
            if(node == null) {
                node = new TrieNode();
                current.map.put(ch,node);
            }
            current = node;
        }
        current.endOfWord = true;
    }



}


class TrieNode {

    Map<Character,TrieNode> map;
    boolean endOfWord;

    public TrieNode() {
        map = new HashMap<>();
        endOfWord = false;
    }
}
