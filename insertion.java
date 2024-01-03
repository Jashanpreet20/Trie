import java.util.*;

class TrieNode {
    char value;
    TrieNode[] children = new TrieNode[26];
    boolean isterminal;

    public TrieNode(char val) {
        this.value = val;

        for (int i = 0; i < 26; i++) {
            this.children[i] = null;
        }
        this.isterminal = false;
    }
}

class make {
    public static void insertion(TrieNode root, String str) {

        System.out.println("Recieved word= "+str+" for insertion");
        if (str.length() == 0) {
            root.isterminal = true;
            return;
        }
        // char nikal liya
        char ch = str.charAt(0);
        // index nikal liya current char ka
        int index = ch - 'a';

        TrieNode child;

        //agr present hai toh 
        if (root.children[index] != null) {
            child = root.children[index];
        } else {
            // absent hai toh new node create krdo
            child = new TrieNode(ch);
            root.children[index] = child;
        }

        // substring 1 first index ko skip krdo then second se start krdo
        insertion(child, str.substring(1));
    }

    public static void main(String[] args) {
        TrieNode root = new TrieNode('#');
        insertion(root, "caring");
    }
}