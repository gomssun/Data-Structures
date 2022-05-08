package Trie;

import java.util.HashSet;
import java.util.Set;

class TrieNode {
    Character element;
    TrieNode[] children; // Assuming only a-z alphabets are allowed
    public TrieNode(){
        this.element = null;
        this.children = new TrieNode[26];
    }
    public TrieNode(Character element){
        this.element = element;
        this.children = new TrieNode[26];
    }
}

public class Trie {
    Integer AUTOCOMPLETE_THRESHOLD = 3; // Indicates the level to which autocomplete search has to be performed.
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    Boolean insert(String word){
        TrieNode currentNode = root;
        for(Character element:word.toCharArray()){
            int index = Character.toLowerCase(element) - 'a'; // To get the position of alphabet index 
            if(currentNode.children[index]==null){
                currentNode.children[index] = new TrieNode(element);
            }
            currentNode = currentNode.children[index];
        }
        return true;
    }
    Boolean find(String word){
        TrieNode currentNode = root;
        for(Character element:word.toCharArray()){
            int index = Character.toLowerCase(element) - 'a';
            if(currentNode.children[index]==null){
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return true;
    }
    Boolean delete(String word){
        return true;
    }
    Set<String> autoCompleteSearch(String word){
        Set<String> suggestions =  new HashSet<String>();
        TrieNode currentNode = root;
        for(Character element:word.toCharArray()){
            int index = Character.toLowerCase(element) - 'a';
            if(currentNode.children[index]==null){
                return suggestions;
            }
            currentNode = currentNode.children[index];
        }
        return getSuggestions(word, word.length()+AUTOCOMPLETE_THRESHOLD, currentNode, suggestions);
    }
    Set<String> getSuggestions(String word, Integer max, TrieNode currentNode, Set<String> suggestions) {
        if(currentNode!=null)
        for(TrieNode children : currentNode.children){
            if(children!=null){
                String prefix = word+children.element;
                if(prefix.length() <= max) {
                    suggestions.add(prefix);
                    getSuggestions(prefix, max, children, suggestions);
                }
            }
        }
        return suggestions;
    }
    Set<String> getWords(String word,TrieNode currentNode) {
        Set<String> suggestions =  new HashSet<String>();
        for(TrieNode children : currentNode.children) {
            if(children!=null){
                suggestions.add(word+ String.valueOf(children.element));
            }
        }
        return suggestions;
    }
}
