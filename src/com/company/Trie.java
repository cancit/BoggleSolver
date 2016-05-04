package com.company;

/**
 * Created by Can on 9.02.2016.
 */
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Trie
{
    private TrieNode root;
    Hashtable<String,TrieNode> foundOnes=new Hashtable<>();
    /**
     * Constructor
     */
    public Trie()
    {
        root = new TrieNode();
    }

    /**
     * Adds a word to the Trie
     * @param word
     */
    public void addWord(String word)
    {
        root.addWord(word.toUpperCase());
    }

    /**
     * Get the words in the Trie with the given
     * prefix
     * @param prefix
     * @return a List containing String objects containing the words in
     *         the Trie with the given prefix.
     */
    public List getWords(String prefix)
    {
        //Find the node which represents the last letter of the prefix
        TrieNode lastNode = root;
        for (int i=0; i<prefix.length(); i++)
        {
            lastNode = lastNode.getNode(prefix.charAt(i));

            //If no node matches, then no words exist, return empty list
            if (lastNode == null) return new ArrayList();
        }

        //Return the words which eminate from the last node
        return lastNode.getWords();
    }
   /* public boolean isWord(String word){
        TrieNode t=getWord(word);
        if(t!=null && t.isWord){
            return true;
        }
         return false;
    }*/
    public TrieNode getWord(String word)
    {
        //Find the node which represents the last letter of the prefix
        TrieNode lastNode = root;
        for (int i=0; i<word.length(); i++)
        {
            lastNode = lastNode.getNode(word.charAt(i));
            if (lastNode!=null && lastNode.isWord && foundOnes.get(lastNode.toString())==null){
                System.out.println(lastNode);
                foundOnes.put(lastNode.toString(),lastNode);

            }
            //If no node matches, then no words exist, return empty list
            if (lastNode == null) return null;
        }

        //Return the words which eminate from the last node
        return lastNode;
    }
}