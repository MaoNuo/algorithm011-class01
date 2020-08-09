class Trie {
    private final static int Nodes = 26;
    Trie[] nextCh;
    boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        this.nextCh = new Trie[Nodes];
        this.isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.nextCh[index] == null) {
                node.nextCh[index] = new Trie();
            }
            node = node.nextCh[index];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.nextCh[index] == null) { return false; }
            node = node.nextCh[index];
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.nextCh[index] == null) { return false; }
            node = node.nextCh[index];
        }
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
