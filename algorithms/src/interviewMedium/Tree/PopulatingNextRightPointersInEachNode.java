package interviewMedium.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {

        Queue<Node> queue = new ArrayDeque<>();

        queue.add(root);


        while(!queue.isEmpty()) {

            int size = queue.size();

            Node next = null;

            for(int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i == 0) {
                    node.next = null;
                } else {
                    node.next = next;
                }

                next = node;


                if (node.right != null) {
                    queue.add(node.right);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }

        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
