package test;

import TreeNode.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeTest {

    public boolean theSame(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (p.val != q.val) return  false;

        return theSame(p.left, q.left) && theSame(p.right, q.right);
    }

    public boolean theSame2(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        else {
            queue.offer(p);
            queue.offer(q);
        }


        while(!queue.isEmpty()) {

            TreeNode first = queue.poll();
            TreeNode second = queue.poll();

            if (first == null && second == null) continue;
            else if (first == null || second == null) return false;
            else if (first.val != second.val) return false;

            queue.offer(first.left);
            queue.offer(second.left);
            queue.offer(first.right);
            queue.offer(second.right);
        }

        return true;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        q.offer(null);
        q.offer(2);
        q.offer(null);


        while(!q.isEmpty()) {
            System.out.println(q.poll());
        }

        System.out.println("size: " + q.size());
    }

    @Test
    public void test() {
        byte i = -128;


        // 1 2 3 4 5 6 7 8 9 A B C D E F

        // 0xFF



        byte aByte = 0b00100001;
        byte xByte = 0xa;
        byte[] bytes = {0b00100001};



        // 00 00 00 00

        byte mask = 0b0111111;


        System.out.println(Integer.toBinaryString(aByte & mask));

        System.out.println(Integer.toBinaryString(128));

    }
}
