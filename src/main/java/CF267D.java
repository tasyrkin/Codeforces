import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF267D {

    private static class Node {
        Character ch;
        int length;
        int rs;
        Node[] children = new Node[27];
        boolean isTerminal = false;

        private Node(final Character ch, final int length, final int rs) {
            this.ch = ch;
            this.length = length;
            if (this.ch == 'r') {
                this.rs = rs + 1;
            }
        }
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        String[] ref = br.readLine().split("\\s+");

        Node root = new Node(null, 0, 0);

        for (String str : ref) {
            char[] chars = str.toLowerCase().toCharArray();

            addChars(root, chars, 0);
        }
    }

    private static void addChars(final Node node, final char[] chars, final int i) {
        if (i >= chars.length) {
            node.isTerminal = true;
            return;
        }

        char curr = chars[i];
        int idx = (int) curr - 97;
        if (node.children[idx] == null) {
            Node newNode = new Node(curr, node.length + 1, node.rs);

            node.children[idx] = newNode;
        }

        addChars(node.children[idx], chars, i + 1);

    }
}
