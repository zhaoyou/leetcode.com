package queue;

import org.junit.Test;

import java.util.*;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Node, Node> map = new HashMap();
        return dfs(node, map);
    }


    private Node dfs(Node cur, Map<Node, Node> map) {


        if (map.containsKey(cur)) return map.get(cur);

        Node newNode = new Node(cur.val, new LinkedList<>());

        map.put(cur, newNode);

        for(Node node:  cur.neighbors) {
            newNode.neighbors.add(dfs(node, map));
        }

        return newNode;
    }


    @Test
    public void test() {
        Node node1 = new Node();
        node1.val = 1;

        Node node2 = new Node();
        node2.val = 2;

        Node node3 = new Node();
        node3.val = 3;

        Node node4 = new Node();
        node4.val = 4;


        node1.neighbors = new ArrayList<>(Arrays.asList(node2, node4));
        node2.neighbors = new ArrayList<>(Arrays.asList(node1, node3));
        node3.neighbors = new ArrayList<>(Arrays.asList(node2, node4));
        node4.neighbors = new ArrayList<>(Arrays.asList(node1, node3));


        System.out.println(cloneGraph(node1));


    }


}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(Node n: neighbors) sb.append(n.val + ", ");
        return "Node{" +
                "val=" + val +
                ", neighbors=" + sb.toString() +
                '}';
    }
};
