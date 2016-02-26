import java.util.*;

/**
 * Given a list of words, you can select any one word and remove a character from
 * it such that it becomes another word in the library. Selected word is then discarded.
 * You can then do the same with the new word in the latter.
 *
 * Now, given an arbitrary library of words, what is the longest chain of words you can
 * play this game with?
 *
 * e.g.:
 * For the library of words: ['a', 'aa', 'bb', 'bbc', 'cbbc'], the longest chain is 3 words
 * because 'cbbc' -> 'bbc' -> 'bb' is the longest chain you can make out of the input set.
 *
 * (NOTE) This solution uses acyclic directed graph build-and-search method, and assumes
 *        or eliminates duplicate words.
 */
public class MyClass {

    // the list of input words, in no particular order
    private List<String> words;

    public MyClass() {
    }

    public int longestChain(List<String> words) {
        // initialize our scratch spaces
        words = new ArrayList<String>(words);
        HashMap<String, Node> nodes = new HashMap<String, Node>();          // mapping each word to a node
        HashMap<Node, Integer> chainLengths = new HashMap<Node, Integer>(); // mapping each node to its longest chain length

        int n = words.size();

        // initialize the maps: create node for each word
        for (String word : words) {
            nodes.put(word, new Node(word));
        }
        // and a count of longest-chain-length for each node
        for (String word : nodes.keySet()) {
            Node node = nodes.get(word);
            chainLengths.put(node, 0);  // 0 indicates not yet determined
        }

        // build the (ADG) graphs
        for (int i = 0; i < n; i++) {
            String word = words.get(i);
            int wordSize = word.length();
            // try removing each character in the current word, and see if it matches any of the shorter words
            for (int j = 0; j < wordSize; j++) {
                String tempstr = trimCharacterAt(word, j);
                Node node = nodes.get(tempstr);
                if (node != null) {
                    // such a word exists! add the associated node to this word's node children
                    nodes.get(word).addChild(node);
                }
            }
        }

        // now we have 1 or more (ADG) graphs whose edges point from longer words to shorter words
        // we need to find the maximum path in each graph, and then find the maximum of those maximum paths

        int answer = 0;
       
        // each node can be thought of as the root of a tree/ADG; so all we have to do is to find
        // the maximum-path-to-a-leaf of each "root" and record the biggest number seen
        HashSet<Node> allNodes = new HashSet<Node>(chainLengths.keySet());
        for (Node node : allNodes) {
            int longestPath = findLongestPath(node, chainLengths);
            chainLengths.put(node, longestPath);
            
            if (longestPath > answer) {
                answer = longestPath;
            }
        }

        System.out.println(chainLengths);

        return answer;
    }

    // given a string, and an index within that string, take out
    // the character on that index, and return the resulting string
    private static String trimCharacterAt(String input, int index) {
        if (index < 0 || index >= input.length()) {
            throw new IndexOutOfBoundsException();
        }
        char[] astr = new char[input.length() - 1];
        for (int i = 0, j = 0; i < input.length(); i++) {
            if (i == index)
                continue;
            astr[j++] = input.charAt(i);
        }
        return new String(astr);
    }

    // a simple graph node in an ADG; associated with a word, and 
    // can have 0-N children (pointees of its outgoing edges)
    private class Node {
        private String word;
        private ArrayList<Node> children;
        public Node(String word) {
            this.word = word;
            children = new ArrayList<Node>();
        }
        public List<Node> getChildren() {
            return children;
        }
        public void addChild(Node child) {
            children.add(child);
        }
        @Override
        public String toString() {
            return "<Node(\"" + word + "\")>";
        }
    }

    // given a node, find the longest path to a leaf;
    // since we can assume that, starting from `node` the graph is ADG, we don't have to worry
    // about cycles; additionally once the longest path of a node is computed, we can update
    // this value in the cache given (`longestPaths`) so that the same computation for a given
    // node is not repeated
    private static int findLongestPath(Node node, Map<Node, Integer> longestPaths) {
        int computed = longestPaths.get(node);
        if (computed != 0) {
            // already determined
            return computed;
        }
        List<Node> children = node.getChildren();
        // base case
        if (children.size() == 0) {
            longestPaths.put(node, 1);
            return 1;
        }
        // recursive case
        int childPath = 0;
        for (Node child : node.getChildren()) {
            int childLongestPath = findLongestPath(child, longestPaths);
            if (childLongestPath > childPath) {
                childPath = childLongestPath;
            }
        }
        assert (childPath > 0);
        longestPaths.put(node, 1 + childPath);
        return 1 + childPath;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        int i=0;
        while ( i<6) {
            String word = input.next();
            words.add(word);
            i++;
        }

        int answer = new MyClass().longestChain(words);
        System.out.println("Longest chain: " + answer);
    }

}