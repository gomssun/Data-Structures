package Trie;

import java.util.Set;

public class TrieMain {
    public static void main(String[] args) throws Exception {
        Trie trie = new Trie();
        System.out.println("Is hello present ? "+trie.find("hello"));
        trie.insert("hello");
        trie.insert("hey");
        trie.insert("heart");
        trie.insert("hen");
        trie.insert("health");
        trie.insert("healthy");
        trie.insert("heat");
        trie.insert("help");
        trie.insert("hat");
        System.out.println("Is hello present ? "+trie.find("hello"));
        System.out.println("Is had present ? "+trie.find("had"));
        System.out.println("Is heat present ? "+trie.find("heat"));
        System.out.println("Is pen present ? "+trie.find("pen"));

        Set<String> suggestions = trie.autoCompleteSearch("h");
        System.out.println("h : "+suggestions);
        suggestions = trie.autoCompleteSearch("he");
        System.out.println("he : "+suggestions);
        suggestions = trie.autoCompleteSearch("ha");
        System.out.println("ha : "+suggestions);
    }
}
