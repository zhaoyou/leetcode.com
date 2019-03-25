package desgin;

import java.util.HashSet;
import java.util.Set;

public class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true

    }
}

class Trie {

    Set<String> set = null;

    /** Initialize your data structure here. */
    public Trie() {
        set = new HashSet<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        set.add(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return set.contains(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        for(String key: set) {
            if (key.startsWith(prefix)) return true;
        }

        return false;
    }
}
