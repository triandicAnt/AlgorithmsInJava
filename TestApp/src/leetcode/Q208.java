package leetcode;

import java.io.*;
import java.util.*;

public class Q208
{
    public static void main (String[] args) throws java.lang.Exception
    {
       Trie trie = new Trie();
        String[] arr = {"abc","abgl","cdf","aecd","lmn"};
        for(String s: arr){
          // trie.insertIterative(s);
        }
        
        System.out.println( trie);
        Trie trie1 = new Trie();
        for(String s: arr){
           trie1.insert(s);
        }
        
       /* for(String s: arr){
           System.out.print(trie.searchIterative(s) + "  ");
        }
        System.out.println("\n"+ trie.searchIterative("lmn"));
        for(String s: arr){
           System.out.print(trie.search(s) + "  ");
        }
        System.out.println("\n"+ trie.search("lmno"));
        */
        //System.out.println( trie1);
//        System.out.println(trie.searchWithIterative("a") == trie.searchWith("a"));
//        System.out.println(trie.searchWithIterative("ab")== trie.searchWith("ab"));
//        System.out.println(trie.searchWithIterative("lmn")== trie.searchWith("lmn"));
//        System.out.println(trie.searchWithIterative("cdf")== trie.searchWith("cdf"));
//        System.out.println(trie.searchWithIterative("lmd")== trie.searchWith("lmd"));
//        System.out.println(trie.searchWithIterative("aed")== trie.searchWith("aed"));
//        System.out.println(trie.searchWithIterative("ae")== trie.searchWith("ae"));
    }
}


class TrieNode {
    // Initialize your data structure here.
    // a children map and a endOfWord flag to mark end of word
    Map<Character,TrieNode> children;
    boolean endOfWord;
    //constructor
    public TrieNode(){
        this.children = new HashMap<>();
        this.endOfWord = false;
    }
    @Override
    public String toString(){
        Set<Character> set = this.children.keySet();
        return set.toString()+"("+this.endOfWord + ")";
    }
}

class Trie {
    private TrieNode root;
    // constructor
    public Trie(){
        this.root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
         // root is created when a new instance of Trie is created
        TrieNode current = this.root;
        for(int i = 0 ;i< word.length();i++){
            // if the character exists then move current to next
            char c = word.charAt(i);
           // System.out.println(c + current.toString());
            
            // current children can not be null because we can instantiating it when TrieNode is instantiated
            TrieNode nextChild = current.children.get(c);
            // if current child is null then create a node and add the entry of c
            if(nextChild==null){
                nextChild = new TrieNode();
                current.children.put(c,nextChild);
            }
            current = nextChild;
            
            // make endOfWord == True if we get to the end of the word
            if(i==word.length()-1)
                current.endOfWord = true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
         TrieNode current = this.root;
        
        for(int i =0;i<word.length();i++){
            // get char at index i
            char c = word.charAt(i);
            TrieNode nextChild = current.children.get(c);
            if(nextChild==null)
                return false;
            current = nextChild;
        }
        // if the end of word is false for that word then word does not exist
        return current.endOfWord==false?false:true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String word) {
          TrieNode current = this.root;
        if(word==null || word.length()==0)
            return false;
        for(int i =0; i<word.length();i++){
            char c = word.charAt(i);
            TrieNode nextChild = current.children.get(c);
            if(nextChild == null)
                return false;
            current = nextChild;
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
