/* package whatever; // don't place package name! */

import java.io.*;
import java.util.*;

public class Trie2
{
    public static void main (String[] args) throws java.lang.Exception
    {
       Trie trie = new Trie();
        String[] arr = {"abc","abgl","cdf","aecd","lmn"};
        for(String s: arr){
           trie.insertIterative(s);
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
        System.out.println(trie.searchWithIterative("a") == trie.searchWith("a"));
        System.out.println(trie.searchWithIterative("ab")== trie.searchWith("ab"));
        System.out.println(trie.searchWithIterative("lmn")== trie.searchWith("lmn"));
        System.out.println(trie.searchWithIterative("cdf")== trie.searchWith("cdf"));
        System.out.println(trie.searchWithIterative("lmd")== trie.searchWith("lmd"));
        System.out.println(trie.searchWithIterative("aed")== trie.searchWith("aed"));
        System.out.println(trie.searchWithIterative("ae")== trie.searchWith("ae"));
    }
}

class TrieNode{
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

class Trie{
    // root node
    public final TrieNode root;
    // constructor
    public Trie(){
        this.root = new TrieNode();
    }
    
    // iterative insert
    public void insertIterative(String word){
       
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
    
    // recursive insert
    public void insert(String word){
        TrieNode current = this.root;
        recursiveInsert(current,word,0);
    }
    public void recursiveInsert(TrieNode current, String word, int index){
        if(index==word.length()){
            current.endOfWord = true;
            return;
        }
        char c = word.charAt(index);
         TrieNode nextChild = current.children.get(c);
        if(nextChild==null){
                nextChild = new TrieNode();
            current.children.put(c,nextChild);
        }
        current = nextChild;
        recursiveInsert(current,word,index+1);
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(Map.Entry<Character,TrieNode> entry: this.root.children.entrySet()){
            sb.append(entry.getKey() + "->" + entry.getValue());
        }
        return sb.toString();
    }
    
    // search the whole word
    // iterative
    public boolean searchIterative(String word){
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
    
    // searchRecursive
    public boolean search(String word){
        TrieNode current = this.root;
        return searchRecursive(current,word,0);
    }
    public boolean searchRecursive(TrieNode current, String word,int index){
        if(index == word.length()){
            return current.endOfWord==false?false:true;
        }
        char c = word.charAt(index);
        TrieNode nextChild = current.children.get(c);
        if(nextChild==null)
            return false;
        current = nextChild;
        return searchRecursive(current,word,index+1);
    }
    
    // search with iterative
    public boolean searchWithIterative(String word){
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
    
    // searchWith recursive
    
     public boolean searchWith(String word){
         TrieNode current = this.root;
        if(word==null || word.length()==0)
            return false;
        return searchWithRecursive( current,  word, 0);
     }
    
     public boolean searchWithRecursive(TrieNode current, String word, int index){
         if(index == word.length())
            return true;
       
        char c = word.charAt(index);
        TrieNode nextChild = current.children.get(c);
        if(nextChild == null)
            return false;
        current = nextChild;
        return searchWithRecursive( current,  word, index+1);
    }
     // delete node
    
    public boolean delete(String word){
        TrieNode current = this.root;
        return delete(current, word, 0);
    }
    
    public boolean delete(TrieNode current, String word, int index){
        if(index == word.length()){
            // return false if this is not the end of word
            if(current.endOfWord == false)
                return false;
            current.endOfWord = false;
            return current.children.size()==0;
        }
        // get the character
        char c = word.charAt(index);
        TrieNode newChild = current.children.get(c);
        // if newChild is null then that word does not exist
        if(newChild == null)
            return false;
        //current  = newChild;
        
        // check the value of next returned char
        boolean shouldDelete = delete(newChild,word,index+1);
        if(shouldDelete==true){
            current.children.remove(c);
            return current.children.size()==0;
        }
        return false;
    }
}
