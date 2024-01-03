import java.util.*;

class TrieNode {
    char value;
    TrieNode[] children = new TrieNode[26];
    boolean isterminal;

    public TrieNode(char val) {
        this.value = val;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
        this.isterminal = false;
    }
}

class make {
    public static void insertion(TrieNode root, String str) {
        // System.out.println(str+" ");
        // base case
        if (str.length() == 0) {
            root.isterminal = true;
            return;
        }

        char ch = str.charAt(0);
        int index = ch - 'a';

        TrieNode child;

        if (root.children[index] != null) {
            // present hai
            child = root.children[index];
        } else {
            child = new TrieNode(ch);
            root.children[index] = child;
        }
        // recursion call
        insertion(child, str.substring(1));
    }

    public static boolean search(TrieNode root, String target) {
        if (target.length() == 0) {
            return root.isterminal;
        }

        char ch = target.charAt(0);
        int index = ch - 'a';

        TrieNode child;
        if (root.children[index] != null) {
            child = root.children[index];
        } else {
            return false;
        }

        return search(child, target.substring(1));

    }
    
    public static void deletion(TrieNode root,String str){
        // base case
        if (str.length() == 0) {
            root.isterminal=false;
            return;
        }
        char ch=str.charAt(0);
        int index=ch - 'a';

        TrieNode child;

        if (root.children[index] != null) {
             child=root.children[index];
        }else{
            return;
        }

        deletion(child, str.substring(1));
    }

    public static void main(String[] args) {
        TrieNode root = new TrieNode('#');
        insertion(root, "caring");
        insertion(root, "cover");
        insertion(root, "rat");
        insertion(root, "cat");
        insertion(root, "code");
        insertion(root, "made");
        insertion(root, "make");
        System.out.println("Insertion Done");

        if (search(root, "cover")) {
            System.out.println("found");
        } else {
            System.out.println("Not Found");
        }

        deletion(root, "cover");

         if (search(root, "cover")) {
            System.out.println("found");
        } else {
            System.out.println("Not Found");
        }
    }
}